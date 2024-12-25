import { useState, useEffect } from "react";
import "./App.css";
import Task from "./components/Task";
import axios from "axios";

function App() {
    const [tasks, setTasks] = useState([]);
    const [taskInput, setTaskInput] = useState("");

    const onTaskInputChange = (e) => {
        setTaskInput(e.target.value);
    };

    const addTask = async (e) => {
        e.preventDefault();
        if (!taskInput.trim()) {
            console.error("Task input is empty");
            return;
        }
        try {
            const res = await axios.post("http://localhost:8080/task", {
                title: taskInput,
                completed: false,
            });
            setTasks([...tasks, res.data]);
            setTaskInput("");
        } catch (error) {
            console.error("Failed to add task", error);
        }
    };

    const fetchTasks = async () => {
        try {
            const res = await axios.get("http://localhost:8080/task");
            setTasks(res.data);
        } catch (error) {
            console.error("Failed to fetch tasks", error);
        }
    };

    const deleteTaskById = async (id) => {
        console.log("Delete task with id", id);
        try {
            await axios.delete(`http://localhost:8080/task/${id}`);
            const newTasks = tasks.filter((task) => task.id !== id);
            setTasks(newTasks);
        } catch (error) {
            console.error("Failed to delete task", error);
        }
    };

    const toggleTaskById = async (id) => {
        console.log("Toggle task with id", id);
        try {
            const task = tasks.find((task) => task.id === id);
            const res = await axios.put(`http://localhost:8080/task/${id}`, {
                title: task.title,
                completed: !task.completed,
            });
            const newTasks = tasks.map((task) =>
                task.id === id ? res.data : task
            );
            setTasks(newTasks);
        } catch (error) {
            console.error("Failed to toggle task", error);
        }
    };

    useEffect(() => {
        fetchTasks();
    }, []);

    return (
        <div className="w-full p-4">
            <div>
                <form className="flex flex-col md:flex-row items-center justify-center space-y-4 md:space-x-4 md:space-y-0">
                    <input
                        type="text"
                        placeholder="Type here"
                        className="input input-bordered w-full md:flex-grow"
                        value={taskInput}
                        onChange={onTaskInputChange}
                    />
                    <button
                        type="submit"
                        onClick={addTask}
                        className="btn btn-primary w-full md:w-auto"
                    >
                        Add Task
                    </button>
                </form>
            </div>
            <div className="container space-y-4 w-full">
                {tasks?.map((task) => (
                    <Task
                        key={task.id}
                        title={task.title}
                        isCompleted={task.completed}
                        onDelete={() => deleteTaskById(task.id)}
                        onToggle={() => toggleTaskById(task.id)}
                    />
                ))}
            </div>
        </div>
    );
}

export default App;

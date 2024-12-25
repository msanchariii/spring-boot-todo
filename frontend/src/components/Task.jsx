function Task({ title, isCompleted, onDelete, onToggle }) {
    return (
        <div className="flex items-center justify-between w-full p-4 mx-auto my-4 bg-primary-content rounded-lg shadow-md">
            <h2>
                <span
                    className={`text-xl ${isCompleted ? "line-through" : ""}`}
                >
                    {title}
                </span>
            </h2>
            <div className="space-x-2">
                <button className="btn" onClick={onToggle}>
                    {isCompleted ? "Mark as Undone" : "Mark as Done"}
                </button>
                <button className="btn btn-error" onClick={onDelete}>
                    Delete
                </button>
            </div>
        </div>
    );
}

export default Task;


### 1. @Entity
   Description: Marks a class as a JPA entity. It means that this class will be mapped to a database table.
   Usage:
   
   ```java
   @Entity
   public class User {
   // fields, methods
   }
   ```
### 2. @Table
   Description: Specifies the name of the database table to which the entity will be mapped.
   Usage: Optional, if not specified, the table name will be assumed to be the same as the class name.
   
```java
   @Entity
   @Table(name = "users")
   public class User {
    // fields, methods
   }
```
### 3. @Id
   Description: Specifies the primary key of the entity.
   
Usage:
   ```java
   @Entity
   public class User {
    @Id
    private Long id;
    // fields, methods
   }
   ```
### 4. @GeneratedValue
   Description: Defines the strategy for generating the primary key value (e.g., auto-increment, sequence).
   
Usage:
   ```java
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
   private Long id;
   ```
### 5. @Column
   Description: Specifies the column that corresponds to a field in the entity.
   Usage: Optional. Used to specify column details (e.g., name, nullable, length).
    
```java
   @Column(name = "username", nullable = false, length = 100)
   private String username;
```
### 6. @ManyToOne
   Description: Defines a many-to-one relationship between entities (e.g., many users can belong to one department).
   Usage:
```java
   @ManyToOne
   @JoinColumn(name = "department_id")
   private Department department;
```
### 7. @OneToMany
   Description: Defines a one-to-many relationship (e.g., one user can have many posts).
   
Usage:
```java
   @OneToMany(mappedBy = "user")
   private Set<Post> posts;
```
### 8. @ManyToMany

Description: Defines a many-to-many relationship (e.g., many students can attend many courses).
   
Usage:
```java
   @ManyToMany
   @JoinTable(
   name = "student_course",
   joinColumns = @JoinColumn(name = "student_id"),
   inverseJoinColumns = @JoinColumn(name = "course_id")
   )
   private Set<Course> courses;
```
### 9. @JoinColumn
   Description: Specifies the foreign key column for a relationship.
   
Usage: Typically used in @ManyToOne or @OneToOne mappings.

```java 
   @ManyToOne
   @JoinColumn(name = "department_id")
   private Department department;
```
### 10. @Transient
    
Description: Marks a field that should not be persisted to the database.
    
Usage:

```java
    @Transient
    private String temporaryField;
```
### 11. @Lob
    
Description: Used to indicate that a field is a large object (LOB), such as a CLOB or BLOB in the database (e.g., storing large text or binary data).
    
Usage:
```java
    @Lob
    private String description;
```

### 12. @Enumerated
    
Description: Used to store an enum as a column in the database.

Usage:
```java
    @Enumerated(EnumType.STRING)
    private Status status;
```

### 13. @Version

Description: Used for optimistic locking. The version column is automatically managed by JPA to ensure data consistency when multiple transactions are trying to modify the same entity.

Usage:
```java
    @Version
    private Integer version;
```
    
### 14. @OneToOne

Defines a one-to-one relationship between two entities (e.g., one user can have one profile).

Usage:

```java
    @OneToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;
```

### 15. @PrePersist and @PreUpdate

These are lifecycle callbacks that are triggered before an entity is persisted or updated in the database.

Usage:

```java
    @PrePersist
    public void onPrePersist() {
    // Custom logic before inserting into the DB
    }
```
```java
    @PreUpdate
    public void onPreUpdate() {
    // Custom logic before updating in the DB
    }
```

#### Example Entity Class

```java
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Version
    private Integer version;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // Getters and Setters
}
```

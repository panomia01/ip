# Dew User Guide

## Introduction
Dew is a simple chatbot that helps users manage their tasks efficiently. It supports adding, editing, deleting, and marking tasks as complete. Users can interact with Dew using text-based commands.

---

## Getting Started

### Prerequisites
- Ensure you have **Java 17** installed on your computer.
- Download the latest **Dew.jar** file from the project repository.

### Running Dew
1. Open a terminal or command prompt.
2. Navigate to the directory where `Dew.jar` is located.
3. Run the command:
   ```sh
   java -jar Dew.jar
   ```

Dew will start and display a greeting message.

---

## Features & Commands

### 1. Listing all tasks
Displays all tasks currently stored in Dew.
#### Usage:
```sh
list
```

### 2. Adding a task
Adds a new task to the list. Dew supports three types of tasks:
- **Todo**: Simple task without a deadline.
- **Deadline**: Task with a specific due date.
- **Event**: Task occurring at a specific time.

#### Usage:
```sh
todo <task description>
deadline <task description> /by <yyyy-mm-dd>
event <task description> /from <TimeStart> /to <TimeEnd>
```
#### Example:
```sh
todo Buy groceries
deadline Submit assignment /by 2025-02-25
event project meeting /from Mon 2pm /to 4pm
```

### 3. Marking a task as done
Marks a specified task as completed.
#### Usage:
```sh
mark <task number>
```
#### Example:
```sh
mark 2
```

### 4. Unmarking a completed task
Marks a specified task as **not completed**.
#### Usage:
```sh
unmark <task number>
```
#### Example:
```sh
unmark 2
```

### 5. Deleting a task
Removes a specified task from the list.
#### Usage:
```sh
delete <task number>
```
#### Example:
```sh
delete 3
```

### 6. Finding a task
Searches for a task based on keywords.
#### Usage:
```sh
find <keyword>
```
#### Example:
```sh
find assignment
```

### 7. Editing a task
Modifies an existing task’s description.

**Task categories:**
- **todo:** description
- **deadline:** description, date
- **event:** description, start, end
#### Usage:
```sh
edit <task number> <task category> <new value>
```
#### Example:
```sh
edit 2 description Buy vegetables
```

### 8. Exiting the application
Closes Dew.
#### Usage:
```sh
bye
```

---
Enjoy using Dew!


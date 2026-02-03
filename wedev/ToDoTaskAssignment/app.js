const taskForm = document.getElementById('taskForm');
const taskInput = document.getElementById('taskInput');
const taskList = document.getElementById('taskList');

class TaskManager {
  constructor() {
    this.tasks = [];
  }

  async fetchTasks() {
    const response = await fetch(
      'https://jsonplaceholder.typicode.com/todos?_limit=5'
    );
    const data = await response.json();
    this.tasks = data.map((task) => ({
      ...task,
      id: crypto.randomUUID(),
    }));
    this.renderTasks();
  }

  addTask(title) {
    const task = {
      id: crypto.randomUUID(),
      title,
      completed: false,
    };
    this.tasks.push(task);
    this.renderTasks();
  }

  toggleTaskCompletion(taskId) {
    this.tasks = this.tasks.map((task) =>
      task.id === taskId ? { ...task, completed: !task.completed } : task
    );
    this.renderTasks();
  }

  deleteTask(taskId) {
    this.tasks = this.tasks.filter((task) => task.id !== taskId);
    this.renderTasks();
  }

  renderTasks() {
    taskList.innerHTML = '';
    this.tasks.forEach(({ id, title, completed }) => {
      const taskItem = document.createElement('li');
      taskItem.textContent = title;
      taskItem.dataset.id = id;
      taskItem.className = completed ? 'completed' : '';

      const deleteButton = document.createElement('button');
      deleteButton.textContent = 'x';
      deleteButton.className = 'delete-button';
      deleteButton.dataset.id = id;

      taskItem.appendChild(deleteButton);
      taskList.appendChild(taskItem);
    });
  }
}

const taskManager = new TaskManager();
taskManager.fetchTasks();

taskForm.addEventListener('submit', (event) => {
  event.preventDefault();
  const { value } = taskInput;
  if (value.trim()) {
    taskManager.addTask(value);
    taskInput.value = '';
  }
});

taskList.addEventListener('click', (event) => {
  const taskItem = event.target;
  const taskId = taskItem.dataset.id;

  if (taskItem.classList.contains('delete-button')) {
    taskManager.deleteTask(taskId);
  } else {
    taskManager.toggleTaskCompletion(taskId);
  }
});

// Pon a prueba tus conocimientos sobre JavaScript aqui

let tasks = ["Task 1"];
let input = document.getElementById("taskInput");
let addButton = document.getElementById("addTaskButton");
let taskList = document.querySelector("#taskList");

let renderTasks = () => {
	let newListItems = [];
	tasks.forEach((e) => {
		let newTask = document.createElement("li");
		let article = document.createElement("article");
		let input = document.createElement("input");
		let span = document.createElement("span");
		let i = document.createElement("i");

		i.classList.add("fa");
		i.classList.add("fa-trash");
		input.type = "checkbox";
		input.classList.add("task-checkbox");
		span.classList.add("task-text");
		span.textContent = e;

		article.appendChild(input);
		article.appendChild(span);
		newTask.appendChild(article);
		newTask.appendChild(i);
		newListItems.push(newTask);
	});
	taskList.replaceChildren(...newListItems);
};

renderTasks();
let checkbox = document.querySelector(".task-checkbox");
var delButton = document.querySelectorAll(".fa-trash");

addButton.addEventListener("click", () => {
	let newValue;

	newValue = input.value;
	if (newValue.trim() === "") return;
	tasks.push(newValue);

	// reset input value
	input.value = "";
	// render tasks
	renderTasks();
	delButton = document.querySelectorAll(".fa-trash");
	listenToDels();
});

let listenToDels = () => {
	delButton.forEach((e) => {
		e.addEventListener("click", () => {
			tasks.splice(
				tasks.indexOf(
					e.parentElement.querySelector(".task-text").textContent
				),
				1
			);
			renderTasks();
			delButton = document.querySelectorAll(".fa-trash");
			listenToDels();
		});
	});
};

listenToDels();

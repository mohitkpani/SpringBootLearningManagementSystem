const API_URL = "/courses";


// ======================================================
// WHEN PAGE LOADS
// ======================================================

document.addEventListener("DOMContentLoaded", function () {

    getAllCourses();

});


// ======================================================
// ADD COURSE
// POST /courses
// ======================================================

document
    .getElementById("addCourseForm")
    .addEventListener("submit", async function (event) {

        event.preventDefault();


        const course = {

            name: document
                .getElementById("courseName")
                .value,

            description: document
                .getElementById("courseDescription")
                .value,

            price: Number(
                document
                    .getElementById("coursePrice")
                    .value
            )

        };


        try {

            const response = await fetch(API_URL, {

                method: "POST",

                headers: {
                    "Content-Type": "application/json"
                },

                body: JSON.stringify(course)

            });


            if (!response.ok) {

                const error = await response.json();

                alert(
                    Object.values(error).join("\n")
                );

                return;
            }


            alert("Course added successfully!");


            document
                .getElementById("addCourseForm")
                .reset();


            getAllCourses();

        }
        catch (error) {

            alert("Unable to connect to backend.");

        }

    });


// ======================================================
// GET ALL COURSES
// GET /courses
// ======================================================

async function getAllCourses() {

    const courseList =
        document.getElementById("courseList");


    try {

        const response =
            await fetch(API_URL);


        if (!response.ok) {

            throw new Error();

        }


        const courses =
            await response.json();


        courseList.innerHTML = "";


        if (courses.length === 0) {

            courseList.innerHTML =
                "<p>No courses available.</p>";

            return;

        }


        courses.forEach(function (course) {

            const div =
                document.createElement("div");


            div.className = "course";


            div.innerHTML = `

                <h3>
                    ${course.name}
                </h3>

                <p>
                    ID: ${course.id}
                </p>

                <p>
                    ${course.description}
                </p>

                <p class="price">
                    ₹ ${course.price}
                </p>

                <div class="course-buttons">

                    <button
                        onclick="findFromCard(${course.id})"
                    >
                        View
                    </button>

                    <button
                        onclick="editFromCard(${course.id})"
                    >
                        Edit
                    </button>

                    <button
                        class="delete"
                        onclick="deleteFromCard(${course.id})"
                    >
                        Delete
                    </button>

                </div>

            `;


            courseList.appendChild(div);

        });

    }
    catch (error) {

        courseList.innerHTML =
            "<p>Unable to connect to backend.</p>";

    }

}


// ======================================================
// FIND COURSE BY ID
// GET /courses/{id}
// ======================================================

async function findCourse() {

    const id =
        document
            .getElementById("findId")
            .value;


    if (!id) {

        alert("Please enter Course ID.");

        return;

    }


    const result =
        document.getElementById("findResult");


    try {

        const response =
            await fetch(`${API_URL}/${id}`);


        if (!response.ok) {

            result.innerHTML =
                `<p>${await response.text()}</p>`;

            return;

        }


        const course =
            await response.json();


        result.innerHTML = `

            <div class="course">

                <h3>
                    ${course.name}
                </h3>

                <p>
                    ID: ${course.id}
                </p>

                <p>
                    ${course.description}
                </p>

                <p class="price">
                    ₹ ${course.price}
                </p>

            </div>

        `;

    }
    catch (error) {

        alert("Unable to connect to backend.");

    }

}


// ======================================================
// VIEW BUTTON
// ======================================================

function findFromCard(id) {

    document
        .getElementById("findId")
        .value = id;


    findCourse();

}


// ======================================================
// EDIT BUTTON
// ======================================================

function editFromCard(id) {

    document
        .getElementById("updateId")
        .value = id;


    loadCourse();

}


// ======================================================
// LOAD COURSE
// GET /courses/{id}
// ======================================================

async function loadCourse() {

    const id =
        document
            .getElementById("updateId")
            .value;


    if (!id) {

        alert("Please enter Course ID.");

        return;

    }


    try {

        const response =
            await fetch(`${API_URL}/${id}`);


        if (!response.ok) {

            alert(await response.text());

            return;

        }


        const course =
            await response.json();


        document
            .getElementById("updateName")
            .value = course.name;


        document
            .getElementById("updateDescription")
            .value = course.description;


        document
            .getElementById("updatePrice")
            .value = course.price;


        document
            .getElementById("updateForm")
            .classList.remove("hidden");

    }
    catch (error) {

        alert("Unable to connect to backend.");

    }

}


// ======================================================
// FULL UPDATE
// PUT /courses/{id}
// ======================================================

async function fullUpdate() {

    const id =
        document
            .getElementById("updateId")
            .value;


    const course = {

        name:
            document
                .getElementById("updateName")
                .value,

        description:
            document
                .getElementById("updateDescription")
                .value,

        price:
            Number(
                document
                    .getElementById("updatePrice")
                    .value
            )

    };


    try {

        const response =
            await fetch(`${API_URL}/${id}`, {

                method: "PUT",

                headers: {

                    "Content-Type":
                        "application/json"

                },

                body:
                    JSON.stringify(course)

            });


        if (!response.ok) {

            alert(await response.text());

            return;

        }


        alert("Course fully updated!");


        getAllCourses();

    }
    catch (error) {

        alert("Unable to connect to backend.");

    }

}


// ======================================================
// PARTIAL UPDATE
// PATCH /courses/{id}
// ======================================================

async function partialUpdate() {

    const id =
        document
            .getElementById("updateId")
            .value;


    const course = {};


    const name =
        document
            .getElementById("updateName")
            .value;


    const description =
        document
            .getElementById("updateDescription")
            .value;


    const price =
        document
            .getElementById("updatePrice")
            .value;


    if (name !== "") {

        course.name = name;

    }


    if (description !== "") {

        course.description = description;

    }


    if (price !== "") {

        course.price = Number(price);

    }


    try {

        const response =
            await fetch(`${API_URL}/${id}`, {

                method: "PATCH",

                headers: {

                    "Content-Type":
                        "application/json"

                },

                body:
                    JSON.stringify(course)

            });


        if (!response.ok) {

            alert(await response.text());

            return;

        }


        alert("Course partially updated!");


        getAllCourses();

    }
    catch (error) {

        alert("Unable to connect to backend.");

    }

}


// ======================================================
// DELETE COURSE
// DELETE /courses/{id}
// ======================================================

async function deleteCourse() {

    const id =
        document
            .getElementById("deleteId")
            .value;


    if (!id) {

        alert("Please enter Course ID.");

        return;

    }


    const confirmDelete =
        confirm(
            "Are you sure you want to delete this course?"
        );


    if (!confirmDelete) {

        return;

    }


    deleteFromCard(id);

}


// ======================================================
// DELETE
// ======================================================

async function deleteFromCard(id) {

    try {

        const response =
            await fetch(`${API_URL}/${id}`, {

                method: "DELETE"

            });


        if (!response.ok) {

            alert(await response.text());

            return;

        }


        alert("Course deleted successfully!");


        getAllCourses();

    }
    catch (error) {

        alert("Unable to connect to backend.");

    }

}
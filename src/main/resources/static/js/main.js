// window.onload = function() {
//     var passwordsList = document.querySelectorAll(".passwordField");
//     passwordsList.forEach(function(i){
//         var content = i.innerHTML;
//         var Hash = md5(content);
//         i.innerHTML = Hash;
//     });
// }


function deleteStudent(id) {    
    var btnDelete = document.getElementById("modalButtonDelete");
    btnDelete.setAttribute("href", "/student/delete/" + id);
}

function updateStudent(id, name, email, password) {
    document.getElementById("modalUpdateForm").action = "/student/update/" + id;
    document.getElementById("modalUpdateInputName").value = name;
    document.getElementById("modalUpdateInputEmail").value = email;
    document.getElementById("modalUpdateInputPassword").value = password;
}





function deleteTeacher(id) {    
    var btnDelete = document.getElementById("modalButtonDelete");
    btnDelete.setAttribute("href", "/teacher/delete/" + id);
}

function updateTeacher(id, name, email, password) {
    document.getElementById("modalUpdateForm").action = "/teacher/update/" + id;
    document.getElementById("modalUpdateInputName").value = name;
    document.getElementById("modalUpdateInputEmail").value = email;
    document.getElementById("modalUpdateInputPassword").value = password;
}
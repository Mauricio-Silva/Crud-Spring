// window.onload = function() {
//     var passwordsList = document.querySelectorAll(".passwordField");
//     passwordsList.forEach(function(i){
//         var content = i.innerHTML;
//         var Hash = md5(content);
//         i.innerHTML = Hash;
//     });
// }



function deleteStudent(id) {    
    var btnDelete = document.getElementById("btnDelete");
    btnDelete.setAttribute("href", "/student/delete/" + id);
}



function selectStudent(id, name, email, password) {
    document.getElementById("modalUpdateForm").action = "/student/update/" + id;
    document.getElementById("modalUpdateInputName").value = name;
    document.getElementById("modalUpdateInputEmail").value = email;
    document.getElementById("modalUpdateInputPassword").value = password;
}



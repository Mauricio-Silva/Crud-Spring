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
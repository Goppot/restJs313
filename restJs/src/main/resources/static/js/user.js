$(document).on("click", ".left-user-btn", function () {
    const btnAdminUser = `<div class="container-fluid div-admin-user">
                            <button class="btn btn left-admin-btn" type="button" style="color: #027cff">Admin</button>
                            <button class="btn btn-primary left-user-btn" type="button" >User</button>    
                         </div>`;
    const informationPage = `<div class="container-fluid admin-panel">
                            <h1>User information-page</h1>
                        </div>`;
    const textTable = `<div class="container-fluid all-users">
                        <h3>About users</h3>
                   </div>`;
    const adminTable = `<div class="container-fluid table-panel">
                        <table class="table table-striped">
                            <thead class="table-panel-thead">
                            <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Name</th>
                            <th scope="col">Age</th>
                            <th scope="col">Email</th>
                            <th scope="col">Role</th>
                            </tr>
                        </thead>
                        <tbody class="table-panel-tbody-user">   
                        </tbody>
                        </table>
                      </div>`;
    document.querySelector(".div-left-body").innerHTML = btnAdminUser;
    document.querySelector(".div-right-body").innerHTML = informationPage + textTable + adminTable;
    getUser();
})
const getUser = () => {
    fetch("http://localhost:8080/api/users/authorized")
        .then(res => res.json())
        .then(user => {
                let test = `<tr>
                             <td>${user.id}</td>
                             <td>${user.name}</td>
                             <td>${user.age}</td>
                             <td>${user.email}</td>
                             <td>${user.nameRole}</td>
                            </tr>`;
                document.querySelector(".table-panel-tbody-user").innerHTML = test
            }
        )
}


$(document).on("click", ".left-admin-btn", function () {
    allAdminPanel();
    getTable();
} )
$(function(){
    $(".header").load("templates/header.html"); 
    $(".main").load("templates/main.html"); 
    $(".footer").load("templates/footer.html"); 
  });

// đi đến trang chủ
function viewHome(){
  $(".main").load("templates/main.html"); 
}

// đi đến danh sách phòng ban
function viewDepartment() {
  $(".main").load("department/main.html", function () {
    initTableDepartment();
  });
}

// đi đến danh sách account
function viewAccount(){
  $(".main").load("account/main.html", function(){
    initTableAccount();
  }); 
}

// show mess thành công
function showAlertSuccess(){
  $("#alert-success").fadeTo(3000,200).slideUp(2000,function(){
      $("#alert-success").slideUp(3000);
  });
}

$(document).ready(function () {
  // Example of handling filter button click
  $('.btn-primary').on('click', function () {
      alert('Filtering results...');
  });

  // Handling edit and delete actions
  $('.btn-warning').on('click', function () {
      alert('Edit action triggered');
  });

  $('.btn-danger').on('click', function () {
      alert('Delete action triggered');
  });
});
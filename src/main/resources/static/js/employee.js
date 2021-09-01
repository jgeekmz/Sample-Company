$('document').ready(function() {

    $('.table .btn-primary').on('click',function(event){
        event.preventDefault();
        var href= $(this).attr('href');
        console.log("HREF >>>>> " + href);
        $.get(href, function(employee, status){
            console.log("HREF >>>>> " + href);
            $('#txtIdEdit').val(employee.id);
            $('#txtFirstnameEdit').val(employee.firstname);
            $('#txtLastnameEdit').val(employee.lastname);
        });
        $('#editModal').modal();
    });

    $('.table #detailsButton').on('click',function(event) {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(employee, status){
            $('#idDetails').val(employee.id);
            $('#fName').val(employee.firstname);
            $('#lName').val(employee.lastname);

        });
        $('#detailsModal').modal();
    });

    $('.table #deleteButton').on('click',function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#deleteModal #delRef').attr('href', href);
        $('#deleteModal').modal();
    });

});
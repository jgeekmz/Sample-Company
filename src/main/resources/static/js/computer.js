$('document').ready(function() {

    $('.table .btn-primary').on('click',function(event){
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(computer, status){
            $('#txtIdEdit').val(computer.id);
            $('#txtcomputerNameEdit').val(computer.computerName);
            $('#txtAddressEdit').val(computer.macAddress);
            $('#txtIPAdressEdit').val(computer.ipAddress);
            $('#txtcomputerEdit').val(computer.empId);
            $('#txtDescEdit').val(computer.description);
            $('#txtempAbbreviationEdit').val(computer.empAbbreviation);
            $('#txtEmpAbbrEdit2').val(computer.empAbbr);
        });
        $('#editModal').modal();
    });

    $('.table #detailsButton').on('click',function(event) {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(computer, status){
            $('#idDetails').val(computer.id);
            $('#compName').val(computer.computerName);
            $('#mac').val(computer.macAddress);
            $('#ip').val(computer.ipAddress);
            $('#desc').val(computer.description);
            $('#empA').val(computer.empAbbr);
            $('#empAbbr').val(computer.empAbbreviation);
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
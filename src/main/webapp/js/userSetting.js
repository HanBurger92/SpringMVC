$(function () {

    // alert message after action
    var msg = $('#message').val();
    if(msg != ''){
        alert(msg);
    }

    $('#user-dialog').dialog({
        autoOpen: false,
        height: 800,
        width: 400,
        modal: true,
        buttons: {
            "confirm": function () {
                form=$('#userForm');
                form.submit();
            },
            "Cancel": function () {
                $(this).dialog("close");
            }
        }
    });

    $("#userForm").validate({
        rules: {
            userName: {
                required: true,
                maxlength: 20
            },
            password: {
                required: true,
                maxlength: 10
            },
            role: {
                required: true
            }
        }
    });

    $('.updateUser').click(function () {
        var userId = $(this).data("id");
        var userName = $(this).data("username");
        var password = $(this).data("password");
        var role = $(this).data("role");

        $('#id').val(userId);
        $('#userName').val(userName);
        $('#password').val(password);
        $('#role').val(role);
        $('#id').prop('readonly', true);
        $('#user-update-dialog').dialog({
            autoOpen: false,
            height: 800,
            width: 400,
            modal: true,
            buttons:{
                "Confirm": function () {
                    form = $('#userUpdateForm');
                    form.submit();
                },
                "Cancel": function () {
                    $(this).dialog("close");
                }
            }
        });
        $('#user-update-dialog').dialog('open');
    });

    $('#userUpdateForm').validate({
        rules: {
            rules: {
                userName: {
                    required: true,
                    maxlength: 20
                },
                password: {
                    required: true,
                    maxlength: 10
                },
                role: {
                    required: true
                }
            }
        }
    });

    $('#create-data').click(function () {
        $('#user-dialog').dialog('open');
    });

});
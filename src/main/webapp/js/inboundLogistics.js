$(function () {

    // alert message after action
    var msg = $('#message').val();
    if(msg != ''){
        alert(msg);
    }

    $('#inbound-dialog').dialog({
        autoOpen: false,
        height: 800,
        width: 400,
        modal: true,
        buttons: {
            "confirm": function () {
                form=$('#inboundForm');
                form.submit();
            },
            "Cancel": function () {
                $(this).dialog("close");
            }
        }
    });

    $("#inboundForm").validate({
        rules: {
            inboundReceipt: {
                required: true,
                maxlength: 20
            },
            inboundDate: "required",
            supplier: {
                required: true,
                maxlength: 10
            },
            recorder: {
                required: true,
                maxlength: 10
            },
            reviewer: {
                required: true,
                maxlength: 10
            },
            price: {
                required: true,
                max: 1000000
            },
            remark: {
                required: true,
                maxlength: 50
            }
        }
    });

    $('.updateInbound').click(function () {
        var inboundReceipt = $(this).data("inboundReceipt");
        var inboundDate = $(this).data("inboundDate");
        var supplier = $(this).data("supplier");
        var recorder = $(this).data("recorder");
        var reviewer = $(this).data("reviewer");
        var price = $(this).data("price");
        var remark = $(this).data("remark");

        $('#inboundReceipt').val(inboundReceipt);
        $('#inboundDate').val(inboundDate);
        $('#supplier').val(supplier);
        $('#recorder').val(recorder);
        $('#reviewer').val(reviewer);
        $('#price').val(price);
        $('#remark').val(remark);
        $('#inboundReceipt').prop('readonly', true);
        $('#inbound-update-dialog').dialog({
            autoOpen: false,
            height: 800,
            width: 400,
            modal: true,
            buttons:{
                "Confirm": function () {
                    form = $('#inboundUpdateForm');
                    form.submit();
                },
                "Cancel": function () {
                    $(this).dialog("close");
                }
            }
        });
        $('#inbound-update-dialog').dialog('open');
    });

    $('#inboundUpdateForm').validate({
        rules: {
            inboundReceipt: {
                required: true,
                maxlength: 20
            },
            inboundDate: "required",
            supplier: {
                required: true,
                maxlength: 10
            },
            recorder: {
                required: true,
                maxlength: 10
            },
            reviewer: {
                required: true,
                maxlength: 10
            },
            price: {
                required: true,
                max: 1000000
            },
            remark: {
                required: true,
                maxlength: 50
            }
        }
    });

    $('#create-data').click(function () {
        $('#inbound-dialog').dialog('open');
    })
});
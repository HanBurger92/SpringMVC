$(function () {

    // alert message after action
    var msg = $('#message').val();
    if(msg != ''){
        alert(msg);
    }

    $('#outbound-dialog').dialog({
        autoOpen: false,
        height: 800,
        width: 400,
        modal: true,
        buttons: {
            "confirm": function () {
                form=$('#outboundForm');
                form.submit();
            },
            "Cancel": function () {
                $(this).dialog("close");
            }
        }
    });

    $("#outboundForm").validate({
        rules: {
            outboundReceipt: {
                required: true,
                maxlength: 20
            },
            outboundDate: "required",
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
                maxlength: 1000000
            },
            remark: {
                required: true,
                max: 50
            }
        }
    });

    $('.updateOutbound').click(function () {
        var outboundReceipt = $(this).data("outboundReceipt");
        var outboundDate = $(this).data("outboundDate");
        var supplier = $(this).data("supplier");
        var recorder = $(this).data("recorder");
        var reviewer = $(this).data("reviewer");
        var price = $(this).data("price");
        var remark = $(this).data("remark");

        $('#outboundReceipt').val(outboundReceipt);
        $('#outboundDate').val(outboundDate);
        $('#supplier').val(supplier);
        $('#recorder').val(recorder);
        $('#reviewer').val(reviewer);
        $('#price').val(price);
        $('#remark').val(remark);
        $('#outboundReceipt').prop('readonly', true);
        $('#outbound-update-dialog').dialog({
            autoOpen: false,
            height: 800,
            width: 400,
            modal: true,
            buttons:{
                "Confirm": function () {
                    form = $('#outboundUpdateForm');
                    form.submit();
                },
                "Cancel": function () {
                    $(this).dialog("close");
                }
            }
        });
        $('#outbound-update-dialog').dialog('open');
    });

    $('#outboundUpdateForm').validate({
        rules: {
            outboundReceipt: {
                required: true,
                maxlength: 20
            },
            outboundDate: "required",
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
        $('#outbound-dialog').dialog('open');
    });

});
var user = "${sessionScope.user}";

jQuery(function ($) {
    $('#demo1').slideBox();
});

var id = "${sessionScope.pet}";

$(function () {
    to_page();
});

function to_page() {
    $("#content").val("");
    //session里面的数据
    $.ajax({
        url: "${path}/comment/petComments?petId=" + "${pet.id}",
        type: "GET",
        success: function (result) {
            submit(result);
        },
        error: function (result) {
            alert("评论导出失败");
        }
    });
}

//字符串拼接
function submit(result) {
    //清空数据
    $(".comment-list").empty();
    //对结果进行遍历
    var comments = result.extend.comment;
    console.log(result.extend.comment);
    $.each(comments, function (index, comment) {
        var headTd = $("<header></header>").append($("<img>").attr("src", "/static/images/user/" + (comment.user.pic)));
        var head = $("<div></div>").addClass("comment-right");
        var userNameTd = $("<h3></h3>").append(comment.user.userName);
        var bodyTd = $("<div></div>").addClass("comment-content-header");
        var timeTd = $("<span></span>").append($("<i></i>").addClass("glyphicon glyphicon-time")).append(comment.commentTime);
        bodyTd.append(timeTd);
        var commentTd = $("<p></p>").addClass("content").append(comment.content);
        var answer = $("<div></div>").addClass("comment-content-footer");
        var answerHead = $("<div></div>").addClass("row");
        var answerbtn = $("<div></div>").addClass("col-md-2").append($("<span></span>").addClass("reply-btn").append("回复").attr("save-id", comment.id));
        answerHead.append(answerbtn);
        answer.append(answerHead);
        var replayListTd = null;
        if (comment.answer != null) {
            var answers = comment.answer;
            replayListTd = $("<div></div>").addClass("reply-list");
            $.each(answers, function (index, answer) {
                if (answer.replayId != null) {
                    var replay = $("<div></div>").append($("<a></a>").append(answer.user.userName)).append("回复：").append($("<a></a>").append(answer.answer.user.userName).append("  ")).append($("<span></span>").append(answer.content));
                    var contentTd = $("<p></p>").append($("<span></span>").append(answer.answerTime)).append($("<span></span>").addClass("reply-list-btn").append("回复").attr("saves-id", answer.id));
                    var replayTd = $("<div></div>").addClass("reply").append(replay).append(contentTd);
                    replayListTd.append(replayTd);
                } else {
                    var replay = $("<div></div>").append($("<a></a>").append(answer.user.userName)).append("回复：").append($("<a></a>").append(comment.user.userName).append("  ")).append($("<span></span>").append(answer.content));
                    var contentTd = $("<p></p>").append($("<span></span>").append(answer.answerTime)).append($("<span></span>").addClass("reply-list-btn").append("回复").attr("saves-id", answer.id));
                    var replayTd = $("<div></div>").addClass("reply").append(replay).append(contentTd);
                    replayListTd.append(replayTd);
                }
            });
        }
        head.append(userNameTd).append(bodyTd).append(commentTd).append(answer).append(replayListTd);
        $("<div></div>").addClass("comment-info")
            .append(headTd)
            .append(head)
            .appendTo(".comment-list")
    });
};

$("#comment").click(function () {
    var comment = $("#content").val();
    if (comment == null) {
        alert("请填入评论后才能发表")
    }
    ;
    $.ajax({
        url: "${path}/comment/create?content=" + comment,
        type: "GET",
        success: function (result) {
            alert("评论插入成功");
            to_page();
        },
        error: function (result) {
            alert("评论插入失败")
        }
    })
});


//清空表单样式及内容
function reset_form(ele) {
    $(ele)[0].reset();
    //清空表单样式
    $(ele).find("*").removeClass("has-error has-success");
    $(ele).find(".help-block").text("");
}

//点击申请按钮弹出模态框。
$("#pet_adopt_modal_btn").click(function () {
    //清除表单数据（表单完整重置（表单的数据，表单的样式））
    reset_form("#new_adopt_form");
    $("#new_id").val("${user.id}");
    $("#new_userName").val("${user.userName}");
    $("#new_sex").val("${user.sex}");
    $("#new_telephone").val("${user.telephone}");
    $("#new_Email").val("${user.email}");
    $("#new_address").val("${user.address}");
    //弹出模态框
    $("#myAdopt").modal({
        backdrop: "static"
    });
});
//点击保存，保存到申请表
$("#submit_btn").click(function () {
    var ted = document.getElementById("new_adopt_form");
    var adopt = new FormData(ted);
    console.log(adopt);
    $.ajax({
        url: "${path}/adopt/create",
        type: "POST",
        processData: false,  // 告诉jQuery不要去处理发送的数据
        contentType: false, // 告诉jQuery不要去设置Content-Type请求头
        date: adopt,//控制层并没有用到这里的数据，可以省略掉
        success: function (result) {
            alert("提交申请成功");
            $("#adopt_btn").click();
        },
        error: function (result) {
            console.log(result);
            alert("提交申请失败");
            $("#adopt_btn").click();
        }
    });
});


$("#tianchuan_btn").click(function () {
    window.location.href = "${path}/user/service";
});

$(document).on("click", ".reply-btn", function () {
    var id = $(this).attr("save-id");
    console.log(id);
    $.ajax({
        url: "${path}/comment/findById?id=" + id,
        type: "GET",
        success: function (result) {
            //填充用户信息
            $("#edit_id").val(result.extend.comment.id);
        }
    });
    //2、弹出模态框
    $("#saveAnswer").modal({
        backdrop: "static"
    });
});

$("#save_answer_btn").click(function () {
    var id = $("#edit_id").val();
    var content = $("#edit_content").val()
    $.ajax({
        url: "${path}/answer/create",
        type: "POST",
        dataType: "json",
        data: {'commentId': id, 'content': content},
        success: function (result) {
            alert("回复成功！");
            $("#comment_btn").click();
            to_page();
        },
        error: function (result) {
            alert("回复失败！");
            $("#comment_btn").click();
        }
    })
});

$(document).on("click", ".reply-list-btn", function () {
    var id = $(this).attr("saves-id");
    console.log(id);
    $.ajax({
        url: "${path}/answer/findById?id=" + id,
        type: "GET",
        success: function (result) {
            console.log(result.extend.answer);
            //填充用户信息
            $("#comment_id").val(result.extend.answer.comment.id);
            $("#answer_id").val(result.extend.answer.id);
        }
    });
    //2、弹出模态框
    $("#saveAnswers").modal({
        backdrop: "static"
    });
});
$("#save_answers_btn").click(function () {
    var comment_id = $("#comment_id").val();
    var id = $("#answer_id").val();
    var content = $("#answer_content").val()
    $.ajax({
        url: "${path}/answer/creates",
        type: "POST",
        dataType: "json",
        data: {'replayId': id, 'content': content, 'commentId': comment_id},
        success: function (result) {
            alert("回复成功！");
            to_page();
            $("#answer_btn").click();
        },
        error: function (result) {
            alert("回复失败！")
            $("#answer_btn").click();
        }
    })
})
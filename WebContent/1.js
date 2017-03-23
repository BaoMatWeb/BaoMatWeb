
$(window).load(function(){
	$dropdown = $("#contextMenu");
	$(".dsDeTai_actionButton").click(function() {
		var id = $(this).closest("tr").children().first().html();
		$(this).after($dropdown);
		$dropdown.find(".payLink").attr("href", "/transaction/pay?id="+id);
		$dropdown.find(".delLink").attr("href", "/transaction/delete?id="+id);
		$(this).dropdown();
	});
});
// $function getInfo()
// {
// 	var f=document.doipass;
// 	if(f.pass.value="")
// 	{
// 		document.getElementById("pass-error").style.display='block';
// 		document.getElementById("pass-error").innnerHTML="Nhập lại mật khẩu!";
// 		f.pass.focus();
// 		return false;
// 	}
// 	else

// 		document.getElementById("pass-error").style.display='none';
// 	return true;
// };

// });
// $function Remove(){
// 	var f=document.sv_table_thongbao
// 	if(f.selectAll_ThongBao)
// 	{
// 		$("btn_Xoa").click(function(){
//      	$("success").remove();
//     });
// 	}
// 	$('input[name="all"],input[name="title"]').bind('click', function(){
// 		var status = $(this).is(':checked');
// 		$('input[type="checkbox"]', $(this).parent('div')).attr('checked', status);
// 		});
// }
/*back to top*/
$(function(){
	$(window).scroll(function()
		{if( $(this).scrollTop()>=200) //keo xuong qua 200 thi hien
			{
				$('#bttop').fadeIn();
			}
			else
			{
				$('#bttop').fadeOut();
			}});
	$('#bttop').click(function(){
		$('body,html').animate({scrollTop:0},600);});});

/*end back to top*/
//$(document).ready(function(){
//	$("input, select,textarea").mouseenter(function(){
//		$(this).css("background-color","#ECECEC" );
//	});
//	$("input, select,textarea").mouseleave(function(){
//		$(this).css("background-color", "#FFFFFF");
//	});
//});


// $(document).ready(function(){
// 	$("#main_dtkt1").click(function(){
//         $("#dt1").slideToggle("slow");
//     });
//     $("#main_dtkt2").click(function(){
//         $("#dt2").slideToggle("slow");
//     });
//     $("#main_dtkt3").click(function(){
//         $("#dt3").slideToggle("slow");
//     });
// });

/*animate thong bao main bounceIn*/

$(document).ready(function(){
	$('.ltbao').hover(function(){
		$(this).addClass("animated bounceIn").one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend',function(){
				$(this).removeClass("animated bounceIn")
		})
	})

});


//validation đổi mật khẩu và cập nhập thông tin
$(document).ready(function() {
 $("#register-form").validate({
 	rules: {

 		pass: {
 			required: true,
 			minlength: 5
 		},
 		npass: {
 			required: true,
 			minlength: 3
 		},
 		cfpass: {
 			required: true,
 			minlength: 3,
 			equalTo: "#npass"
 		},
 		
 	},
 	  highlight: function(element) {
	    var id_attr = "#" + $(element).attr("id") + "1";
	    $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
	    $(id_attr).removeClass('glyphicon-ok').addClass('glyphicon-remove');
	  },
	  unhighlight: function(element) {
	    var id_attr = "#" + $(element).attr("id") + "1";
	    $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
	    $(id_attr).removeClass('glyphicon-remove').addClass('glyphicon-ok');
	  },
	  errorElement: 'span',
	  errorClass: 'help-block',
	  errorPlacement: function(error, element) {
	    if (element.length) {
	      error.insertAfter(element);
	    } else {
	      error.insertAfter(element);
	    }
	  },
 	messages: {
 		
 		pass: {
 			required: 'Vui lòng nhập mật khẩu',
 			minlength: 'Vui lòng nhập ít nhất 3 kí tự'
 		},
 		npass: {
 			required: 'Vui lòng nhập mật khẩu mới',
 			minlength: 'Vui lòng nhập ít nhất 3 kí tự'
 		},
 		cfpass: {
 			required: 'Vui lòng nhập lại mật khẩu',
 			minlength: 'Vui lòng nhập ít nhất 3 kí tự',
 			equalTo: 'Mật khẩu không trùng'
 		},
 		
 	}
 });
});
$(document).ready(function() {
$("#formcntt").validate({
	rules: {

		email: {
			required: true,
			email: true
		},
		nganh: "required",
		cnnganhang: "required",
		donvi: "required",
	},
	highlight: function(element) {
	    var id_attr = "#" + $(element).attr("id") + "1";
	    $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
	    $(id_attr).removeClass('glyphicon-ok').addClass('glyphicon-remove');
	  },
	  unhighlight: function(element) {
	    var id_attr = "#" + $(element).attr("id") + "1";
	    $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
	    $(id_attr).removeClass('glyphicon-remove').addClass('glyphicon-ok');
	  },
	  errorElement: 'span',
	  errorClass: 'help-block',
	  errorPlacement: function(error, element) {
	    if (element.length) {
	      error.insertAfter(element);
	    } else {
	      error.insertAfter(element);
	    }
	  },
	messages: {
		
		email: {
			required: "Please provide a password",
			minlength: "Your password must be at least 5 characters long",
			equalTo: "Please enter the same password as above"
		},
		email: "Email phải có dạng 'a@b.c'",
		nganh: "Vui lòng nhập chi nhánh ngân hàng",
		cnnganhang: "Vui lòng nhập chi nhánh ngân hàng",
		donvi: "Vui lòng nhập đơn vị công tác",
	}
});
});

$(document).ready(function() {
	 $("#loginform").validate({
	 	rules: {

	 		password: {
	 			required: true,
	 			minlength: 3
	 		},
	 		Email: {
				required: true,
				email: true
			}
	 		
	 	},
	 	  highlight: function(element) {
		    var id_attr = "#" + $(element).attr("id") + "1";
		    $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
		    $(id_attr).removeClass('glyphicon-ok').addClass('glyphicon-remove');
		  },
		  unhighlight: function(element) {
		    var id_attr = "#" + $(element).attr("id") + "1";
		    $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
		    $(id_attr).removeClass('glyphicon-remove').addClass('glyphicon-ok');
		  },
		  errorElement: 'span',
		  errorClass: 'help-block',
		  errorPlacement: function(error, element) {
		    if (element.length) {
		      error.insertAfter(element);
		    } else {
		      error.insertAfter(element);
		    }
		  },
	 	messages: {
	 		
	 		password: {
	 			required: 'Vui lòng nhập mật khẩu',
	 			minlength: 'Vui lòng nhập ít nhất 3 kí tự'
	 		},
	 		Email: "Email phải có dạng 'a@b.c'"
	 		
	 	}
	 });
	});
//form dkdetai
$(document).ready(function() {
	$("#formDKDT").validate({
		rules: {

			email: {
				required: true,
				email: true
			},
			mssv: {
	 			required: true,
	 			minlength: 3
	 		},
	 		tenCN: "required",
	 		tenGVHD: "required",
	 		ngaybatdau: {
	 			required: true,
	 			date: true	
	 		},
	 		ngayketthuc: {
	 			required: true,
	 			date: true	
	 		}
		},
		highlight: function(element) {
		    var id_attr = "#" + $(element).attr("id") + "1";
		    $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
		    $(id_attr).removeClass('glyphicon-ok').addClass('glyphicon-remove');
		  },
		  unhighlight: function(element) {
		    var id_attr = "#" + $(element).attr("id") + "1";
		    $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
		    $(id_attr).removeClass('glyphicon-remove').addClass('glyphicon-ok');
		  },
		  errorElement: 'span',
		  errorClass: 'help-block',
		  errorPlacement: function(error, element) {
		    if (element.length) {
		      error.insertAfter(element);
		    } else {
		      error.insertAfter(element);
		    }
		  },
		messages: {
			
			email: {
				required: "Please provide a password",
				minlength: "Your password must be at least 5 characters long",
				equalTo: "Please enter the same password as above"
			},
			email: "Email phải có dạng 'a@b.c'",
			mssv: {
	 			required: 'Vui lòng nhập mssv',
	 			minlength: 'Vui lòng nhập ít nhất 3 kí tự'
	 		},
	 		tenCN: "Vui lòng nhập tên chủ nhiệm",
	 		tenGVHD: "Vui lòng nhập tên GVHD",
	 		ngaybatdau: "Ngày phải có dạng dd/mm/yy",
	 		ngayketthuc: "Ngày phải có dạng dd/mm/yy"
		}
	});
	});

//$(document).ready(function() {
//
//    $.fn.goValidate = function() {
//        var $form = this,
//            $inputs = $form.find('input:text, input:password'),
//            $selects = $form.find('select'),
//            $textAreas = $form.find('textarea');
//
//        var validators = {
//            name: {
//                regex: /^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]+(?=\s*\S).*$/,
//            },
//            mssv: {
//                regex: /^[A-Za-z0-9]{6,}$/
//            },
//            mota: {
//               regex: /^(?=\s*\S).*$/,
//            },
//           
//            ngay: {
//                regex: /^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/
//            },
//            dxuatkinhphi: {
//                regex: /^[0-9]\d{0,6}$/
//            },
//            // password1: {
//            //     regex: /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}/
//            // },
//            // password1_repeat: {
//            //     regex: /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}/
//            // },
//            email: {
//                regex: /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/
//            },
//            diem1: {
//                regex: /^(1[0-0]|[0-9])$/
//            },
//            diem2: {
//                regex: /^(1[0-5]|[0-9])$/
//            },
//            diem3: {
//                regex: /^(3[0-5]|[0-9])$/
//            },
//            diem4: {
//            	regex: /^(10[0-0]|[0-9])$/
//            },
//            // phone: {
//            //     regex: /^[0-9]\d{7,12}$/
//            // },
//            // body: {
//            //     regex: /^.{3,}$/
//            // },
//            // country: {
//            //     regex: /^(?=\s*\S).*$/,
//            // }
//        };
//        var validate = function(klass, value) {
//            var isValid = true,
//                error = '';
//
//            if (!value && /required/.test(klass)) {
//                error = 'This field is required';
//                isValid = false;
//            } else {
//                klass = klass.split(/\s/);
//                $.each(klass, function(i, k) {
//                    if (validators[k]) {
//                        if (value && !validators[k].regex.test(value)) {
//                            isValid = false;
//                            error = validators[k].error;
//                        }
//                    }
//                });
//            }
//            return {
//                isValid: isValid,
//                error: error
//            }
//        };
//        var showError = function($e) {
//            var klass = $e.attr('class'),
//                value = $e.val(),
//                test = validate(klass, value);
//
//            $e.removeClass('invalid');
//            $('#form-error').addClass('hide');
//
//            if (!test.isValid) {
//                $e.addClass('invalid');
//
//                if (typeof $e.data("shown") == "undefined" || $e.data("shown") == false) {
//                    $e.popover('show');
//                }
//
//            } else {
//                $e.popover('hide');
//            }
//        };
//
//        $inputs.keyup(function() {
//            showError($(this));
//        });
//        $selects.change(function() {
//            showError($(this));
//        });
//        $textAreas.keyup(function() {
//            showError($(this));
//        });
//
//        $inputs.on('shown.bs.popover', function() {
//            $(this).data("shown", true);
//        });
//
//        $inputs.on('hidden.bs.popover', function() {
//            $(this).data("shown", false);
//        });
//
//        $form.submit(function(e) {
//
//            $inputs.each(function() { /* test each input */
//                if ($(this).is('.required') || $(this).hasClass('invalid')) {
//                    showError($(this));
//                }
//            });
//            $selects.each(function() { /* test each input */
//                if ($(this).is('.required') || $(this).hasClass('invalid')) {
//                    showError($(this));
//                }
//            });
//            $textAreas.each(function() { /* test each input */
//                if ($(this).is('.required') || $(this).hasClass('invalid')) {
//                    showError($(this));
//                }
//            });
//            if ($form.find('input.invalid').length) { /* form is not valid */
//                e.preventDefault();
//                $('#form-error').toggleClass('hide');
//            }
//        });
//        return this;
//    };
//
//
//
//    $('form').goValidate();
//
//});



$(function() {
	$("#btn_Xoa").on("click", function() {
		var rowCount = $('tbody input').length;
		var i=0;
		var temp=0;
		for(i;i<rowCount;i++)
		{
			if($('tbody input').eq(i).is(":checked"))
			{

				$('tbody tr').eq(i).hide(2000);
				temp++;
			}
		}
		if(temp!=0)
		{
			setTimeout(function () {
				alert('Xóa thành công')}, 2000);
		}
	});
});
// $(function(){
// 	function checkform()
// 	{
// 		var f = document.forms[".form_HuyGH"].elements;
// 		var cansubmit=true;
// 		for (var i = 0; i < f.length; i++) {
// 			if (f[i].value.length==0) cansubmit=false;
// 		}
// 		if (cansubmit)
// 		{
// 			document
// 			.getElementById('btn_GuiDon'
// 				).disabled=false;
// 		}
// 	};

// });

//$(function() {
//	$('form').submit(function() {
//		var res = true;
//		$("input[type='text'],select,input[type='password']",this).each(function() {
//			if($(this).val().trim() == "") {
//				res = false; 
//			}
//			else
//			{
//				alert('Thành công!');
//				res=true;
//			}
//		})
//		return res; 
//	});
//});

//tìm kiếm theo GVHD,MDETAI,KEYWWORD của thèn quản lý
$(function() {
$("#tkiem").on("click", function () {
	if ($("#tkql").val() == "madetai") 
	{
		// Declare variables 
        var input, filter, table, tr, td, i;
		input = document.getElementById("myInput");
		filter = input.value.toUpperCase();
		table = document.getElementById("myTable");
		tr = table.getElementsByTagName("tr");

		// Loop through all table rows, and hide those who don't match the search query
		for (i = 0; i < tr.length; i++)
		 {
			td = tr[i].getElementsByTagName("th")[0];
			if (td) 
			{
				if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
					tr[i].style.display = "";
				} else {
					tr[i].style.display = "none";
				}
			}
		}
	};
		if ($("#tkql").val() == "stendt") 
		{
			// Declare variables 
            var input, filter, table, tr, td, i;
			input = document.getElementById("myInput");
			filter = input.value.toUpperCase();
			table = document.getElementById("myTable");
			tr = table.getElementsByTagName("tr");

			// Loop through all table rows, and hide those who don't match the search query
			for (i = 0; i < tr.length; i++)
			 {
				td = tr[i].getElementsByTagName("th")[1];
				if (td) 
				{
					if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
						tr[i].style.display = "";
					} else {
						tr[i].style.display = "none";
					}
				}
			}
		}
		else 
			{
			if ($("#tkql").val() == "tengvhd") 
    		{
    			// Declare variables 
               
    			input = document.getElementById("myInput");
    			filter = input.value.toUpperCase();
    			table = document.getElementById("myTable");
    			tr = table.getElementsByTagName("tr");

    			// Loop through all table rows, and hide those who don't match the search query
    			for (i = 0; i < tr.length; i++)
    			 {
    				td = tr[i].getElementsByTagName("th")[3];
    				if (td) 
    				{
    					if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
    						tr[i].style.display = "";
    					} else {
    						tr[i].style.display = "none";
    					}
    				}
    			}
    		}
			else
				{
				if ($("#tkql").val() == "tatca") 
        		{
                    var td1,td2,td3;
        			input = document.getElementById("myInput");
        			filter = input.value.toUpperCase();
        			table = document.getElementById("myTable");
        			tr = table.getElementsByTagName("tr");
        			for (i = 0; i < tr.length; i++)
        			 {
        				td = tr[i].getElementsByTagName("th")[0];
        				td1 = tr[i].getElementsByTagName("th")[1];
        				td2 = tr[i].getElementsByTagName("th")[2];
        				td3 = tr[i].getElementsByTagName("th")[3];
        				if (td) 
        				{
        					if ((td.innerHTML.toUpperCase().indexOf(filter) > -1) ||(td1.innerHTML.toUpperCase().indexOf(filter) > -1) ||(td2.innerHTML.toUpperCase().indexOf(filter) > -1) ||(td3.innerHTML.toUpperCase().indexOf(filter) > -1)  ) {
        						tr[i].style.display = "";
        					} else {
        						tr[i].style.display = "none";
        					}
        				}
        			}
        		}
				}
			}
	})
});
//hết tìm kiếm quản lý
/*
Please consider that the JS part isn't production ready at all, I just code it to show the concept of merging filters and titles together !
*/
//Demo of Searching and Sorting Table with AngularJS
//var myApp = angular.module('myApp', []);
//
//myApp.controller('TableCtrl', ['$scope', function ($scope) {
//
//    $scope.allItems = getDummyData();
//
//    $scope.resetAll = function () {
//        $scope.filteredList = $scope.allItems;
//        $scope.newEmpId = '';
//        $scope.newName = '';
//        $scope.newEmail = '';
//        $scope.searchText = '';
//    }
//
//    $scope.add = function () {
//        $scope.allItems.push({
//            EmpId: $scope.newEmpId,
//            name: $scope.newName,
//            Email: $scope.newEmail
//        });
//        $scope.resetAll();
//    }
//
//    $scope.search = function () {
//        $scope.filteredList = _.filter($scope.allItems,
//
//        function (item) {
//            return searchUtil(item, $scope.searchText);
//        });
//
//        if ($scope.searchText == '') {
//            $scope.filteredList = $scope.allItems;
//        }
//    }
//
//    $scope.resetAll();
//}]);

/* Search Text in all 3 fields */
// bắt đầu search của sinh viên
$(document).ready(function() {
	  $(".search").keyup(function () {
	    var searchTerm = $(".search").val();
	    var listItem = $('.results tbody').children('tr');
	    var searchSplit = searchTerm.replace(/ /g, "'):containsi('")
	    
	  $.extend($.expr[':'], {'containsi': function(elem, i, match, array){
	        return (elem.textContent || elem.innerText || '').toLowerCase().indexOf((match[3] || "").toLowerCase()) >= 0;
	    }
	  });
	    
	  $(".results tbody tr").not(":containsi('" + searchSplit + "')").each(function(e){
	    $(this).attr('visible','false');
	  });

	  $(".results tbody tr:containsi('" + searchSplit + "')").each(function(e){
	    $(this).attr('visible','true');
	  });

	  var jobCount = $('.results tbody tr[visible="true"]').length;

	  if(jobCount == '0') {$('.no-result').show();}
	    else {$('.no-result').hide();}
			  });
	});
	
// kết thúc search

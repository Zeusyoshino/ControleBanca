<%-- 
    Document   : index
    Created on : 14/12/2016, 12:50:26
    Author     : Mylena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap/css/datepicker3.css" rel="stylesheet">
<link href="bootstrap/css/styles.css" rel="stylesheet">

<!--[if lt IE 9]>
<script src="bootstrap/js/html5shiv.js"></script>
<script src="bootstrap/js/respond.min.js"></script>
<![endif]-->

</head>
 
<body>
	
	<div class="row">
		<div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
			<div class="login-panel panel panel-default">
				<div class="panel-heading">Login</div>
				<div class="panel-body">
                                    <form action="Executa" method="POST" name="Login" role="form">
						<fieldset>
							<div class="form-group">
								<input class="form-control" placeholder="Email" name="email" type="email" autofocus="" required>
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="Senha" name="senha" type="password" value="" required>
							</div>
							<input type="submit" class="btn btn-primary" value="Entrar">
                                                        <input type="hidden" name="tarefa" value="Login"> 
						</fieldset>
					</form>
				</div>
			</div>
		</div><!-- /.col-->
	</div><!-- /.row -->	
	
		

	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script>
		!function ($) {
			$(document).on("click","ul.nav li.parent > a > span.icon", function(){		  
				$(this).find('em:first').toggleClass("glyphicon-minus");	  
			}); 
			$(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
		}(window.jQuery);

		$(window).on('resize', function () {
		  if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
		})
		$(window).on('resize', function () {
		  if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
		})
	</script>	
</body>

</html>

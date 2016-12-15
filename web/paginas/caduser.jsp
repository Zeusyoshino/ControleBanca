<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>IF Banca</title>

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap/css/datepicker3.css" rel="stylesheet">
<link href="bootstrap/css/styles.css" rel="stylesheet">

<script src="bootstrap/js/jquery.mask.min.js"></script>


<!--Icons-->
<script src="bootstrap/js/lumino.glyphs.js"></script>


<!--[if lt IE 9]>
<script src="bootstrap/js/html5shiv.js"></script>
<script src="bootstrap/js/respond.min.js"></script>
<![endif]-->

</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				
				<a class="navbar-brand" href="home.html"><span>IF</span>Banca</a>
				<ul class="user-menu">
					<li class="dropdown pull-right">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> Usuário <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="editperfil.html"><svg class="glyph stroked male-user"><use xlink:href="altuser.jsp"></use></svg> Editar perfil </a></li>
							<li><a href="logout.html"><svg class="glyph stroked cancel"><use xlink:href="logout.jsp"></use></svg> Sair </a></li>
						</ul>
					</li>
				</ul>
			</div>
							
		</div><!-- /.container-fluid -->
	</nav>
		
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<form role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Buscar">
			</div>
		</form>
		

	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="home.html"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
				<li class="active">Cadastro de usuário</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Cadastro de usuário</h1>
			</div>
		</div><!--/.row-->
				
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="col-md-12">
                                                    <form data-toggle="validator" role="form" action="Executa" method="POST">
                                                            
								<div class="form-group">
									<label>Nome</label>
                                                                        <input class="form-control" name="nome" maxlength="100" required>
                                                                        <div class="help-block with-errors"></div>
                                                                </div>
								
                                                                <div class="form-group">
									<label>Email</label>
                                                                        <input type="email" id="inputEmail" class="form-control" name="email" maxlength="50" required >
                                                                        <div class="help-block with-errors"></div>
                                                                </div>
                                                                
                                                                <div class="form-group">
									<label>Confirme seu Email</label>
                                                                        <input type="email" class="form-control" id="texto" name="confemail" maxlength="50" data-match="#inputEmail" data-match-error="Os emails não estão iguais." required>
                                                                        <div class="help-block with-errors"></div>
                                                                </div>
                                                            
								<div class="form-group">
									<label>Senha</label>
                                                                        <input type="password" class="form-control" id="inputPassword" name="senha" data-minlength="8" required>
                                                                        <span class="help-block">Mínimo de oito (8) dígitos</span>
                                                                        <div class="help-block with-errors"></div>
								</div>
                                                            
                                                                <div class="form-group">
									<label>Confirme sua senha</label>
                                                                        <input type="password" class="form-control" id="inputConfirm" name="confsenha" data-match="#inputPassword" data-match-error="Atenção! As senhas não estão iguais." required>
                                                                        <span class="help-block">Mínimo de oito (8) dígitos</span>
                                                                        <div class="help-block with-errors"></div>
                                                                </div>
								
                                                                <div class="form-group">
									<label>Celular</label>
                                                                        <input type="tel" class="form-control" id="telefone" name="celular" maxlength="15" required>
                                                                        <div class="help-block with-errors"></div>
                                                                </div>                                                         
							
                                                                <div class="form-group">
                                                                        <label>Nível de acesso:</label>
                                                                        <select class="form-control" name="nivel">
                                                                            <option>Selecione o nível</option>
                                                                            <option value="1">Admin</option>
                                                                            <option value="2">Orientador</option>
                                                                            <option value="3">Convidado</option>
                                                                        </select>
                                                                </div> 
                                                            
								<button type="submit" class="btn btn-primary">Enviar</button>
                                                                <input type="hidden" name="tarefa" value="NovoUsuario"> 
                                                                
							</div>
						</form>
                                                    
					</div>
				</div>
			</div><!-- /.col-->
		</div><!-- /.row -->
		
	</div><!--/.main-->

	<script src="bootstrap/js/jquery-1.11.1.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="bootstrap/js/chart.min.js"></script>
	<script src="bootstrap/js/chart-data.js"></script>
	<script src="bootstrap/js/easypiechart.js"></script>
	<script src="bootstrap/js/easypiechart-data.js"></script>
	<script src="bootstrap/js/bootstrap-datepicker.js"></script>
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

            $(document).ready(function() {
                $('#texto').bind('cut copy paste', function(event) {
                    event.preventDefault();
                }); 
            });
            
            $("#telefone").mask("(00) 00000-0000");
            
            
                
	</script>
        <script src="bootstrap/js/validator.min.js"></script>
        
</body>

</html>

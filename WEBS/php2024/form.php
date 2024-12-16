<!-- 
Primeiro nome
apelidos
email
confirmacao de email
data de nascimento
telemovel 
-->
<?php
if(!empty($_POST)){
	$errors=array();
	//print_r($_POST);
	if(empty($_POST["firstname"])){
		$errors["firstname"] = "O campo é de preenchimento obrigatório";
	} else if (strlen(trim($_POST["firstname"])) < 3) {
		$errors["firstname"] = "O campo deve ter pelo menos 3 caracteres";
	}
}
?>
<form id="myform" method="POST" autocomplete="off">
  <fieldset>
      <legend>Registro</legend>
		<label for="firstname">Nome:</label><br>
		<input type="text" name="firstname" id="firstname" value="" placeholder="Insira o seu nome"><br>
		<?php if(isset($errors["firstname"])) {echo $errors["firstname"];} ?>
		<label for="lastname">Apelido:</label><br>
		<input type="text" name="lastname" id="lastname" value="" placeholder="Insira o seu apelido"><br>
		<label for="email">Email:</label><br>
		<input type="text" name="email" id="email" value="" placeholder="Insira o seu email"><br>
		<label for="confirmemail">Confirme email:</label><br>
		<input type="text" name="confirmemail" id="confirmemail" value="" placeholder="Confirme o seu email"><br>
		<label for="password">Password:</label><br>
		<input type="text" name="password" id="password" value="" placeholder="Defina a sua password"><br>
		<label for="confirmpassword">Confirme password:</label><br>
		<input type="text" name="confirmpassword" id="confirmpassword" value="" placeholder="Confirme a sua password"><br>
		<label for="birthdate">Data Nascemento</label><br>
		<input type="date" name="birthdate" id="birthdate" value="" placeholder="Insira a sua data de nascimento"><br>
		<label for="telemovel">Telemovel:</label><br>
		<input type="text" name="telemovel" id="telemovel" value="" placeholder="Insira o seu telemovel"><br><br>
		<input type="submit" value="Enviar" onclick="">
  </fieldset>
</form>
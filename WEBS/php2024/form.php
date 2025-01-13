<!-- 
Primeiro nome
apelidos
email
confirmacao de email
data de nascimento
telemovel 
-->
<?php

$firstname = "";
$lastname = "";
$email = "";
$confirmemail = "";
$password = "";
$confirmpassword = "";
$birthdate = "";
$telemovel = "";

if(!empty($_POST)){
	$errors=array();
	// Validamos nomes
	if(empty($_POST["firstname"])){
		$errors["firstname"] = "O nome é de preenchimento obrigatório";
	} else if (strlen(trim($_POST["firstname"])) < 3) {
		$errors["firstname"] = "O campo deve ter pelo menos 2 caracteres";
	} else if (is_numeric($_POST["firstname"])) {
		$errors["firstname"] = "O campo não pode ser numérico";
	} else {
		$firstname = $_POST["firstname"];
	}

	// Validamos apelidos
	if(empty($_POST["lastname"])){
		$errors["lastname"] = "O apelido é de preenchimento obrigatório";
	} else if (strlen(trim($_POST["lastname"])) < 2) {
		$errors["lastname"] = "O campo deve ter pelo menos 2 caracteres";
	} else if (is_numeric($_POST["lastname"])) {
		$errors["lastname"] = "O campo não pode ser numérico";
	} else {
		$lastname = $_POST["lastname"];
	}

	// Validamos email
	if(empty($_POST["email"])){
		$errors["email"] = "O email é de preenchimento obrigatório";
	} else if (!filter_var($_POST["email"], FILTER_VALIDATE_EMAIL)) {
		$errors["email"] = "O email não é válido";
	} else {
		$email = $_POST["email"];
	}
	// Validamos confirmemail
	if(empty($_POST["confirmemail"])){
		$errors["confirmemail"] = "O campo é de preenchimento obrigatório";
	} else if ($_POST["email"] != $_POST["confirmemail"]) {
		$errors["confirmemail"] = "Os emails não coincidem";
	} else {
		$confirmemail = $_POST["confirmemail"];
	}
	// Validamos password
	if(empty($_POST["password"])){
		$errors["password"] = "A senha é de preenchimento obrigatório";
	} elseif(strlen(trim($_POST["password"])) < 8 || strlen(trim($_POST["password"])) > 20) {
		$errors["password"] = "A senha deve ter entre 8 e 20 caracteres";
	} elseif(!preg_match('/[A-Z]/',$_POST["password"])) {
		$errors["password"] = "A senha deve conter pelo menos 1 letra maiúscula";
	} elseif(!preg_match('/[a-z]/',$_POST["password"])) {
		$errors["password"] = "A senha deve conter pelo menos 1 letra minúscula";
	} elseif(!preg_match('/[0-9]/',$_POST["password"])) {
		$errors["password"] = "A senha deve conter pelo menos 1 número";
	} elseif(!preg_match('/[^\w]/',$_POST["password"])) {
		$errors["password"] = "A senha deve conter pelo menos 1 caractere especial";
	} else {
		$password = $_POST["password"];
	}
	// Validamos confirmpassword
	if(empty($_POST["confirmpassword"])){
		$errors["confirmpassword"] = "O campo é de preenchimento obrigatório";
	} else if ($_POST["password"] != $_POST["confirmpassword"]) {
		$errors["confirmpassword"] = "As senhas não coincidem";
	} else {
		$confirmpassword = $_POST["confirmpassword"];
	}
	// Validamos birthdate
	if(empty($_POST["birthdate"])){
		$errors["birthdate"] = "A data é de preenchimento obrigatório";
	} else {
		$data = DateTime::createFromFormat('Y-m-d', $_POST["birthdate"]);
		if (!$data) {
			$errors["birthdate"] = "A data não é valida"; 
		} else {
			$dataHoje = new DateTime();
			$idade = $dataHoje->diff($data)->y;
			if ($data->format('Y-m-d') >= $dataHoje->format('Y-m-d')){
				$errors["birthdate"] = "A data deve ser anterior a data de hoje";
			} elseif ($idade < 18){
				$errors["birthdate"] = "A idade não poder ser menor a 18 anos";
			} elseif ($idade > 120){
				$errors["birthdate"] = "A idade não poder ser maior a 120 anos";
			} else {
				$birthdate = $_POST["birthdate"];
			}
		}
	}
	// Validamos telemovel
	if (empty($_POST["telemovel"])) {
		$errors["telemovel"] = "O número de telemovel é de preenchimento obrigatório";
	} else {
		$_POST["telemovel"] = str_replace(" ", "", $_POST["telemovel"]);
		// Tiramos o + se houver
		if ($_POST["telemovel"][0] == '+') {
			$_POST["telemovel"] = substr($_POST["telemovel"], 1);
		}
		if(!is_numeric($_POST["telemovel"])){
			$errors["telemovel"] = "não e numerico";
		} elseif (strlen(trim($_POST["telemovel"])) != 9 && strlen(trim($_POST["telemovel"])) != 12 && strlen(trim($_POST["telemovel"])) != 14) {
			$errors["telemovel"] = "O número de telemovel é invalido";
		} else {
			$telemovel = $_POST["telemovel"];
			switch (strlen(trim($_POST["telemovel"]))) {
				case 9:
					if($_POST["telemovel"][0] != 9) $errors["telemovel"] = "O número de telemovel é invalido";
					break;
				case 12:
					if($_POST["telemovel"][3] != 9) $errors["telemovel"] = "O número de telemovel é invalido";
					break;
				case 14:
					if($_POST["telemovel"][5] != 9) $errors["telemovel"] = "O número de telemovel é invalido";
					break;
			}
		}
	}
	if (isset($_FILES['image'])){
		$errors["image"] = "Deve escolher uma imagem";
	} else {
		// Proceso de subida de imagen
		$directorio = 'uploads';
		if (!file_exists($directorio)) {
			mkdir($directorio, 0777, true);  // Crear el directorio si no existe
		}
		// Obtener la imagen desde el formulario
		$imagen = $_FILES['image'];
		// Verificar si hubo un error al subir la imagen
		if ($imagen['error'] !== UPLOAD_ERR_OK) {
			$errors["image"] = "Hubo un error al subir la imagen.";
		} else {
			// Obtener la información de la imagen
			$datahoje = date("YmdHis");
			$nombreImagen = $datahoje . basename($imagen['name']);
			$rutaImagen = $directorio ."/". $nombreImagen;

			// Verificar que el archivo sea una imagen
			$tipoImagen = mime_content_type($imagen['tmp_name']);
			if (strpos($tipoImagen, 'image') === false) {
				$errors["image"] = "El archivo no es una imagen válida.";
			}

			// Mover la imagen al directorio de destino
			if (move_uploaded_file($imagen['tmp_name'], $rutaImagen)) {
				// Redirigir al formulario para mostrar la imagen cargada
				$_POST["image"] = $rutaImagen;
			} else {
				$errors["image"] = "Hubo un error al mover la imagen.";
			}
		}
	};
	// JSON: Ler e escrever no ficheiro o json
	$array = [];
	if(file_exists("json.txt")){
		$json = file_get_contents("json.txt");
		$array = json_decode($json, true);
	} else {
		$array = [];
	}
	// Adicionamos o novo registo ao array
	$postAlterado = $_POST;
	unset($postAlterado['confirmemail']);
	unset($postAlterado['confirmpassword']);
	$array[] = $postAlterado;
	$json = json_encode($array);
	// Escrevemos o array no ficheiro
	file_put_contents("json.txt", $json);
}
?>
<form method="POST" autocomplete="off" enctype="multipart/form-data">
  <fieldset>
      <legend>Registro</legend>
		<label for="firstname">Nome:</label><br>
		<input type="text" name="firstname" id="firstname" value="<?php echo $firstname; ?>" placeholder="Insira o seu nome"><br>
		<?php if(isset($errors["firstname"])) {echo $errors["firstname"];} ?><br>

		<label for="lastname">Apelido:</label><br>
		<input type="text" name="lastname" id="lastname" value="<?php echo $lastname; ?>" placeholder="Insira o seu apelido"><br>
		<?php if(isset($errors["lastname"])) {echo $errors["lastname"];} ?><br>

		<label for="email">Email:</label><br>
		<input type="text" name="email" id="email" value="<?php echo $email; ?>" placeholder="Insira o seu email"><br>
		<?php if(isset($errors["email"])) {echo $errors["email"];} ?><br>

		<label for="confirmemail">Confirme email:</label><br>
		<input type="text" name="confirmemail" id="confirmemail" value="<?php echo $confirmemail; ?>" placeholder="Confirme o seu email"><br>
		<?php if(isset($errors["confirmemail"])) {echo $errors["confirmemail"];} ?><br>
		
		<label for="password">Password:</label><br>
		<input type="text" name="password" id="password" value="<?php echo $password; ?>" placeholder="Defina a sua password"><br>
		<?php if(isset($errors["password"])) {echo $errors["password"];} ?><br>

		<label for="confirmpassword">Confirme password:</label><br>
		<input type="text" name="confirmpassword" id="confirmpassword" value="<?php echo $confirmpassword; ?>" placeholder="Confirme a sua password"><br>
		<?php if(isset($errors["confirmpassword"])) {echo $errors["confirmpassword"];} ?><br>

		<label for="birthdate">Data Nascemento</label><br>
		<input type="date" name="birthdate" id="birthdate" value="<?php echo $birthdate; ?>" placeholder="Insira a sua data de nascimento"><br>
		<?php if(isset($errors["birthdate"])) {echo $errors["birthdate"];} ?><br>

		<label for="telemovel">Telemovel:</label><br>
		<input type="text" name="telemovel" id="telemovel" value="<?php echo $telemovel; ?>" placeholder="Insira o seu telemovel"><br>
		<?php if(isset($errors["telemovel"])) {echo $errors["telemovel"];} ?><br>

		<label for="image">Foto de perfil:</label><br>
		<input type="file" name="image" id="image" accept="image/*"><br>
		<?php if(isset($errors["image"])) {echo $errors["image"];} ?><br>
		<br><br>

		<input type="submit" value="Enviar">
  </fieldset>
</form>




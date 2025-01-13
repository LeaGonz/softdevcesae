<?php
// $arraytest = array("1" => "Primeiro nome", "2" => "apelidos", "3" => "email", 
// "4" => "confirmacao de email", "5" => "data de nascimento", "6" => "telemovel");

// 6- Ler o ficheiro txt
$bd = "testjson.txt";
$json = file_get_contents($bd);
$arraytest = json_decode($json, true);
print_r($arraytest);
echo "<br><br>";
// 1- Convertir o array em json
$json = json_encode($arraytest);
print_r($json);
echo "<br><br>";

// 2- Convertir o json em array
$arraytest = json_decode($json, true);
print_r($arraytest);
echo "<br><br>";

// 3- Gravar novos dados no array
$arraytest["8"] = "password";
print_r($arraytest);
echo "<br><br>";

// 4- Convertir o array em json
$json = json_encode($arraytest);
print_r($json);
echo "<br><br>";

// 5- Gravar o json num ficheiro txt
file_put_contents($bd, $json);
?>
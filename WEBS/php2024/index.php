<?php
//isto é um comentário
$ola = "<h2>Hello Wolrd</h2>";
echo $ola;
echo "<br>";

$numeroum = 8;
$numerodois = 4;

echo "Soma: ";
echo $numeroum + $numerodois;
echo "<br>";
echo "Subtração: ";
echo $numeroum - $numerodois;
echo "<br>";
echo "Multiplicação: ";
echo $numeroum * $numerodois;
echo "<br>";
echo "Divisão: ";
echo $numeroum / $numerodois;

echo "<br><br>Soma: ". ($numeroum + $numerodois) ."<br>";
echo "Subtração: ". ($numeroum - $numerodois) ."<br>";
echo "Multiplicação: ". ($numeroum * $numerodois) ."<br>";
echo "Divisão: ". ($numeroum / $numerodois) ."<br><br>";

echo "<h3>ARRAYS</h3><br>";

$meuarray[]=8;
$meuarray[]=0;
//Outras formas de declarar:
//$meuarray=[8,0];
//$meuarray=array(8,0);
//$meuarray=array(0=>8, 1=>0);

print_r($meuarray);
echo "<pre>"; //pre = mostra formato original
print_r($meuarray);
echo "</pre>";
//exit(); // não executa as linhas a seguir
echo "<br>Soma: ". $meuarray[0] + $meuarray[1] ."<br>";
echo "Substração: ". $meuarray[0] - $meuarray[1] ."<br>";
echo "Multiplicação: ". $meuarray[0] * $meuarray[1] ."<br>";

echo "<h3>IF</h3><br>";

if($meuarray[1] != 0){
echo "Divisão: ". $meuarray[0] / $meuarray[1] ."<br>";
} else {
	echo "Não é possível fazer a divisão por zero!<br><br>";
}

echo "<h3>FOR</h3><br>";

for($i=2; $i<=5; $i++){
	if(12 % $i == 0){
		echo "12 é divisivel por " .$i ."<br>";
	} else{
		echo "12 não é divisivel por " .$i ."<br><br>";
	}
}

$numero = 12;
$dividendos=array(2,3,4,5);

foreach($dividendos as $dividendo){
	if($numero%$dividendo == 0){
		echo "O " .$numero. " é divisivel por " .$dividendo. "<br>";
	} else{
		echo "O " .$numero. " não é divisivel por " .$dividendo. "<br><br>";
	}
}

echo "<h3>DO WHILE</h3><br>";

$i=0;
do{
	if($numero%$dividendos[$i] == 0){
		echo "O " .$numero. " é divisivel por " .$dividendos[$i]. "<br>";
	} else{
		echo "O " .$numero. " não é divisivel por " .$dividendos[$i]. "<br>";
	}
	$i++;
} while($i < count($dividendos));

echo "<h3>Function</h3><br>";

verificardivisiveis($dividendos,$numero);
Function verificardivisiveis($dividendos,$numero){
	$i=0;
	while($i < count($dividendos)){
		if($numero%$dividendos[$i] == 0){
		echo "O " .$numero. " é divisivel por " .$dividendos[$i]. "<br>";
	} else{
		echo "O " .$numero. " não é divisivel por " .$dividendos[$i]. "<br>";
	}
	$i++;
	}
}

$result = verificardivisiveisArr($dividendos,$numero);
echo "<pre>";
print_r ($result[1]);
echo "</pre>";

Function verificardivisiveisArr($dividendos,$numero){
	$i=0;
	while($i < count($dividendos)){
		if($numero%$dividendos[$i] == 0){
		$results[]="O " .$numero. " é divisivel por " .$dividendos[$i]. "<br>";
	} else{
		$results[]="O " .$numero. " não é divisivel por " .$dividendos[$i]. "<br>";
	}
	$i++;
	}
	return $results;
}

$result= verificardivisiveisArrys($dividendos,$numero);

/*foreach($result as $res){
	if($res["numdivisivel"] == 3){
		echo "Nova função: " .$res["text"];
	}
}*/
numerodivisivel($result, 2);
Function numerodivisivel($result, $num){
	foreach($result as $res){
		if($res["numdivisivel"] == $num){
			echo "Nova função: " .$res["text"];
		}
	}
}

Function verificardivisiveisArrys($dividendos,$numero){
	$i=0;
	while($i < count($dividendos)){
		if($numero%$dividendos[$i] == 0){
		$results[]=array("text" => "O " .$numero. " é divisivel por " .$dividendos[$i]. "<br>", "numdivisivel" => $dividendos[$i]);
	} else{
		$results[]=array("text" => "O " .$numero. " não é divisivel por " .$dividendos[$i]. "<br>", "numdivisivel" => $dividendos[$i]);
	}
	$i++;
	}
	return $results;
}

$sons=array(
    "Gato" => "Miau",
    "Cão" => "AuAu",
    "Pássaro" => "Piu"
);
 
foreach ($sons as $animal => $sons){
    echo "<br>O som que o " . $animal . " faz é " . $sons . "<br>";
}
?>
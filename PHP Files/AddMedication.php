<?php
require "CONN.php";
//$user_ID=2;
$user_ID=urldecode($_POST['myid']);
//$table_name = urldecode($_POST['table']);
$table_name = "medication";
$medication = urldecode($_POST['medication']);
//$medication = "tramadol";
$doct_ID=201301111;

$time = urldecode($_POST['time']);
$period = urldecode($_POST['period']);
//$period = 4;
$comment = urldecode($_POST['comment']);
//$comment="try not to die";

if($table_name=="medication"){

$mysql_qry = "INSERT INTO medication ( Name, Period,NumberOfTimes, Instructions, DoctorID,PatientID) VALUES ('".$medication."','".$period."','".$time."','".$comment."' ,'".$doct_ID."','".$user_ID."')"; 
}



mysql_select_db('medication');
$retval = mysql_query( $mysql_qry, $connect );
if(! $retval )
{
  die('Could not add the medication: ' . mysql_error());
}
echo "Medication added successfully\n";
mysql_close($connect);



?>	




	
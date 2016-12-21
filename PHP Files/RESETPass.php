<?php
require "CONN.php";

$userid = urldecode($_POST['userid']);
$table = urldecode($_POST['table']);

if($table =="doctor")
$mysql_qry = "UPDATE doctor SET setPass = '1' WHERE DoctorID = '".$userid."' ";

else
$mysql_qry = "UPDATE patient SET setPass = '1' WHERE PatientID = '".$userid."' ";

echo $mysql_qry;
$result = mysql_query($mysql_qry);

if(!$result)
echo "Error: User ID does not exist.";
?>	
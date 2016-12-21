<?php
require "CONN.php";
$name = urldecode($_POST['name']);
$mail = urldecode($_POST['mail']);
$pass = urldecode($_POST['pass']);
$mobile = urldecode($_POST['mobile']);
$address = urldecode($_POST['address']);
$blood = urldecode($_POST['blood']);
$notes = urldecode($_POST['notes']);

$error = "";
//Check all fields are filled
if (strlen($name) < 5 || strlen($mail)<5 || strlen($pass)<6 || strlen($mobile)<5 || empty($address) || empty($blood) ){
$error = " Error: Please, Fill all fields with valid data";}

//Check mail entered is valid
else if (!filter_var($mail, FILTER_VALIDATE_EMAIL))
$error = " Error: Please, Enter a valid mail address".$mail." ".$mobile;

//echo $error;
if (empty($error))
{
$mysql_qry = "select * from patient where Mail ='".$mail."' OR Mobile='".$mobile."' ";
$result = mysql_query($mysql_qry) ;
if(mysql_num_rows($result) > 0) $error = " Error: Mail or Mobile Entered already exists";
}

if (empty($error))
{
$mysql_qry = "INSERT INTO patient ( Name, Mail, Password, Mobile, Address, Blood, notes)
VALUES ( '".$name."', '".$mail."', '".$pass."', '".$mobile."', '".$address."', '".$blood."', '".$notes."')";
$result = mysql_query($mysql_qry) ;
if (!$result) $error = " Error: ".mysql_error();
else
{
 $mysql_qry = "SELECT PatientID FROM patient WHERE Mail = '".$mail."' ";
 $result = mysql_query($mysql_qry) ;
 $row = mysql_fetch_row($result);
 $error = "Added Patient ID: ".$row[0];
}
mysql_close($connect);
}

echo $error; 
?>		
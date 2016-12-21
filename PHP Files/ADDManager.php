<?php
require "CONN.php";

$name = urldecode($_POST['name']);
$mail = urldecode($_POST['mail']);
$pass = urldecode($_POST['pass']);
$mobile = urldecode($_POST['mobile']);

$error = "";
//Check all fields are filled
if (strlen($name) < 4 || strlen($mail) < 5 || strlen($pass) < 6 || strlen($mobile) < 10 )
$error = "Error: Please, Fill all fields with valid data";

//Check mail entered is valid
else if (!filter_var($mail, FILTER_VALIDATE_EMAIL))
$error = "Error: Please, Enter a valid mail address".$mail." ".$mobile;


if (empty($error))
{
$mysql_qry = "select * from manager where Mail ='".$mail."' OR Mobile='".$mobile."' ";
$result = mysql_query($mysql_qry) ;
if(mysql_num_rows($result) > 0) $error = "Error: Mail or Mobile Entered already exists";
}

if (empty($error))
{
$mysql_qry = "INSERT INTO manager ( Name, Mail, Password, Mobile)
VALUES ( '".$name."', '".$mail."', '".$pass."', '".$mobile."' )";
$result = mysql_query($mysql_qry) ;
if ($result) $error = "Manager is Added";
else $error = "Error: ".mysql_error();
}

echo $error; 
?>	
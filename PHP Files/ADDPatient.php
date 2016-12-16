<?php
require "CONN.php";

$name = urldecode($_POST['name']);
$mail = urldecode($_POST['mail']);
$pass = urldecode($_POST['pass']);
$mobile = urldecode($_POST['mobile']);
$ImgURL = urldecode($_POST['imgurl']);
$address = urldecode($_POST['address']);
$blood = urldecode($_POST['blood']);
$notes = urldecode($_POST['notes']);

echo strlen($name);
$error = "";
//Check all fields are filled
if (strlen($name) < 5 || strlen($mail)<5 || strlen($pass)<6 || strlen($mobile)<10 || empty($ImgURL) || empty($address) || empty($blood) ){
$error = " Error: Please, Fill all fields with valid data";}// echo $error;}

//Check mail entered is valid
else if (!filter_var($mail, FILTER_VALIDATE_EMAIL))
$error = " Error: Please, Enter a valid mail address".$mail." ".$mobile;


//Check IMG URL entered is valid
else if (!preg_match("/\b(?:(?:https?|ftp):\/\/|www\.)[-a-z0-9+&@#\/%?=~_|!:,.;]*[-a-z0-9+&@#\/%=~_|]/i",$ImgURL))
$error = " Error: Image URL is invalid";

//echo $error;
if (empty($error))
{
$mysql_qry = "select * from patient where Mail ='".$mail."' OR Mobile='".$mobile."' ";
$result = mysql_query($mysql_qry) ;
if(mysql_num_rows($result) > 0) $error = " Error: Mail or Mobile Entered already exists";
}

if (empty($error))
{
$mysql_qry = "INSERT INTO patient ( Name, Mail, Password, Mobile, ImgURL, Address, Blood, notes)
VALUES ( '".$name."', '".$mail."', '".$pass."', '".$mobile."', '".$ImgURL."', '".$address."', '".$blood."', '".$notes."')";
$result = mysql_query($mysql_qry) ;
if ($result) $error = "Patient is Added";
else $error = " Error: ".mysql_error();
}

echo $error; 
?>	
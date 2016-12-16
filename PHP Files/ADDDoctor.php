<?php
require "CONN.php";

$name = urldecode($_POST['name']);
$mail = urldecode($_POST['mail']);
$pass = urldecode($_POST['pass']);
$mobile = urldecode($_POST['mobile']);
$ImgURL = urldecode($_POST['imgurl']);
$specialization = urldecode($_POST['spec']);
$review = 0;
$fees = urldecode($_POST['fees']);
$education = urldecode($_POST['edu']);

$error = "";
//Check all fields are filled
if (strlen($name) < 4 || strlen($mail) < 5 || strlen($pass) < 8 || strlen($mobile) < 10 || empty($ImgURL) || empty($fees) || empty($education) || empty($specialization))
$error = "Error: Please, Fill all fields with valid data";

//Check mail entered is valid
else if (!filter_var($mail, FILTER_VALIDATE_EMAIL))
$error = "Error: Please, Enter a valid mail address".$mail." ".$mobile;


//Check IMG URL entered is valid
else if (!preg_match("/\b(?:(?:https?|ftp):\/\/|www\.)[-a-z0-9+&@#\/%?=~_|!:,.;]*[-a-z0-9+&@#\/%=~_|]/i",$ImgURL))
error = "Error: Image URL is invalid";

if (empty($error))
{
$mysql_qry = "select * from doctor where Mail ='".$mail."' OR Mobile='".$mobile."' ";
$result = mysql_query($mysql_qry) ;
if(mysql_num_rows($result) > 0) $error = "Error: Mail or Mobile Entered already exists";
}

if (empty($error))
{
$mysql_qry = "INSERT INTO doctor ( Name, Mail, Password, Mobile, Review, ImgURL, Specialization, Fees, Education)
VALUES ( '".$name."', '".$mail."', '".$pass."', '".$mobile."', '".$review."', '".$ImgURL."', '".$specialization."', '".$fees."', '".$education."')";
$result = mysql_query($mysql_qry) ;
if ($result) $error = "Doctor is Added";
else $error = mysql_error();
}

echo $error; 
?>	
<?php
require "CONN.php";

//$user_ID=urldecode($_POST['doctorid']);;
$user_ID=14;

$user_mail = urldecode($_POST['email']);
$user_mobile = urldecode($_POST['mobile']);
$user_password = urldecode($_POST['password']);
$user_address = urldecode($_POST['address']);
//$image = $_POST['image'];

$mysql_qry = "UPDATE patient SET Mail ='".$user_mail."' , Mobile ='".$user_mobile."', Password='".$user_password."', Address='".$user_address."'  WHERE PatientID ='".$user_ID."' ";


echo $mysql_qry;
$retval = mysql_query( $mysql_qry);
if(! $retval )
{
  die("Could not update data: " . mysql_error());
}
echo "Updated data successfully\n";

?>	


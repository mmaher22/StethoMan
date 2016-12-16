<?php
require "CONN.php";
//$user_ID=urldecode($_POST['myid']);
$user_ID=201301111;

$user_mail = urldecode($_POST['email']);
$user_mobile = urldecode($_POST['mobile']);
$user_password = urldecode($_POST['password']);

$user_awards = urldecode($POST['awards']);

$mysql_qry = "UPDATE doctor SET Mail ='".$user_mail."' , Mobile ='".$user_mobile."', Password='".$user_password."', Awards='".$user_awards."'  WHERE DoctorID =201301111";


mysql_select_db('doctor');
$retval = mysql_query( $mysql_qry, $connect );
if(! $retval )
{
  die("Could not update data: " . mysql_error());
}
echo "Updated data successfully\n";
mysql_close($connect);



?>	




<?php
require "CONN.php";
$name = urldecode($_POST['name']);
$table = urldecode($_POST['table']);
$userid = urldecode($_POST['myid']);
$mob = urldecode($_POST['mob']);

if($table == "patient")
$mysql_qry = "select * from ".$table. " where PatientID ='".$userid."' AND Mobile = '".$mob."' ";
else
$mysql_qry = "select * from ".$table. " where DoctorID ='".$userid."' AND Mobile = '".$mob."' ";

$result = mysql_query($mysql_qry) ;

if(mysql_num_rows($result) > 0 )
{
  $msg = "User of ID: ".$userid." Whose Name is: ".$name." and Mobile: ".$mob." Requested new password request";
  $mysql_qry = "INSERT INTO message ( toid, fromid, content, fromtype, totype) VALUES ( '0', '".$userid."', '".$msg."', '".$table."', 'Manager' )";
  $result = mysql_query($mysql_qry);
  if(!$result) echo mysql_error();
}

else echo "Error: UserID does not exist";

?>
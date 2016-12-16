<?php
require "CONN.php";
$user_name = urldecode($_POST['myid']);
$table_name = urldecode($_POST['table']);
$user_pass = urldecode($_POST['password']);

if($table_name == "manager")
$mysql_qry = "select * from ".$table_name. " where ManagerID ='".$user_name."' and password='".$user_pass."' ";
else if($table_name == "doctor")
$mysql_qry = "select * from ".$table_name. " where DoctorID ='".$user_name."' and password='".$user_pass."' ";
else
$mysql_qry = "select * from ".$table_name. " where PatientID ='".$user_name."' and password='".$user_pass."' ";

$result = mysql_query($mysql_qry) ;
if(mysql_num_rows($result) > 0) {
echo "Logged in Successfully";
}
else {
echo "UserID and Password Combination does not exist";
}
?>	
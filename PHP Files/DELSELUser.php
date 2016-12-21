<?php
require "CONN.php";

$user_id = urldecode($_POST['myid']);
$user_table = urldecode($_POST['table']);

if($user_table == 'doctor')
$mysql_qry = "select Name from doctor where DoctorID ='".$user_id."' ";
else
$mysql_qry = "select Name from patient where PatientID ='".$user_id."' ";

$result = mysql_query($mysql_qry) ;
if(mysql_num_rows($result) > 0) {
$row = mysql_fetch_row($result);
echo "User Name: ".$row[0];
}
else
echo "Error: User ID not found";

?>	




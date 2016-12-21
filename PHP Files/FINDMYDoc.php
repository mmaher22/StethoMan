<?php
require "CONN.php";

$userid = urldecode($_POST['myid']);

$out = "MYDOC";
$mysql_qry = "SELECT doctor.DoctorID, Name FROM doctor, visit WHERE doctor.DoctorID = visit.DoctorID AND visit.PatientID = '".$userid."' ";
$result = mysql_query($mysql_qry) ;

while($row_data = mysql_fetch_array($result))
{
  $name = $row_data['Name'];
  $id = $row_data['DoctorID'];
  $out = $out."-".$name." (doctor) ID: ".$id;
}

$out = $out."-";
echo $out;
?>	
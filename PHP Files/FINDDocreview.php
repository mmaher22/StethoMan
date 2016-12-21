<?php
require "CONN.php";


$out = "DOC";
$myid = urldecode($_POST['myid']);
$mysql_qry = "SELECT * FROM doctor, visit WHERE doctor.DoctorID = visit.DoctorID AND visit.PatientID = '".$myid."' ";
$result = mysql_query($mysql_qry) ;

while($row_data = mysql_fetch_array($result))
{
  $name = $row_data['Name'];
  $id = $row_data['DoctorID'];
  $out = $out."-".$name." ID: ".$id;
}

$out = $out."-";
echo $out;
?>	
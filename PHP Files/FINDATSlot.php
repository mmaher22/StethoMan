<?php
require "CONN.php";
$time = urldecode($_POST['time']);
$spec = urldecode($_POST['spec']);

$out = "SLOT";
$mysql_qry = "select doctor.DoctorID, SlotID, Name, Time from timeslot, doctor 
WHERE doctor.DoctorID = timeslot.DoctorID AND isAvailable = '1' AND Time > NOW() AND Specialization = '".$spec."' AND date(Time) = '".$time."' ";

$result = mysql_query($mysql_qry) ;

while($row_data = mysql_fetch_array($result))
{
  $docname = $row_data['Name'];
  $docid = $row_data['DoctorID']; 
  $time = $row_data['Time'];
  $id = $row_data['SlotID'];
  $out = $out."/"."Dr: ".$docname." ID(".$docid.") At ".$time." ID* ".$id;
}
$out = $out."/";

echo $out;
?>	
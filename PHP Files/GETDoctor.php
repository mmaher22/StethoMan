<?php
require "CONN.php";
$docid = urldecode($_POST['docid']);

$mysql_qry = "select * FROM  doctor WHERE DoctorID = '".$docid."' "; 
$result = mysql_query($mysql_qry);

if($row_data = mysql_fetch_array($result))
{
  $docname = $row_data['Name'];
  $docedu = $row_data['Education']; 
  $docfees = $row_data['Fees'];
  $docmail = $row_data['Mail'];
  $docrating = $row_data['Review'];
  $out = "Dr: ".$docname."/".$docedu."/".$docfees."/".$docmail."/".$docrating;
}

echo $out;
?>	
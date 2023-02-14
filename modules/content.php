 <div class="content">
    	<div class="box_contains">
        	<?php
				if(isset($_GET['quanly'])&&$_GET['ac']){
					$tam=$_GET['quanly'];
					$tam1=$_GET['ac'];
					}else{
						$tam='';
					}if(($tam == 'loaisp')&&($tam1 == 'them')){
						include('modules/quanlyloaisp/them.php');
					}elseif(($tam == 'loaisp')&&($tam1 == 'lietke')){
						
						include('modules/quanlyloaisp/lietke.php');
					}elseif(($tam == 'loaisp')&&($tam1 == 'sua')){
						
						include('modules/quanlyloaisp/sua.php');
					}elseif(($tam == 'sanpham')&&($tam1 == 'them')){
						
						include('modules/quanlysanpham/them.php');
					}elseif(($tam == 'sanpham')&&($tam1 == 'lietke')){
						
						include('modules/quanlysanpham/lietke.php');
					}elseif(($tam == 'sanpham')&&($tam1 == 'sua')){
						
						include('modules/quanlysanpham/sua.php');
					}elseif(($tam == 'nguoidung')&&($tam1 == 'lietke')){

						include('modules/selectuser.php');
					}elseif(($tam == 'hoadon')&&($tam1 == 'lietke')){

						include('modules/quanlysanpham/hoadon/hoadon.php');
					}elseif(($tam == 'hoadon')&&($tam1 == 'chitiet')){

						include('modules/quanlysanpham/hoadon/chitiethd.php');
					}elseif(($tam == 'timkiem')&&($tam1 == 'sp')){
						
						include('modules/timkiem/timkiem.php');
					}else{
						include('modules/quanlysanpham/lietke.php');
					}
			?>
        
        </div>
    </div>
    <div class="clear"></div>
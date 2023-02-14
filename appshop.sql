-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 19, 2021 lúc 07:51 AM
-- Phiên bản máy phục vụ: 10.4.17-MariaDB
-- Phiên bản PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `appshop`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `binhluan`
--

CREATE TABLE `binhluan` (
  `id` int(50) NOT NULL,
  `iduser` int(50) NOT NULL,
  `idsp` int(50) NOT NULL,
  `noidung` varchar(2000) NOT NULL,
  `thoigian` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiethd`
--

CREATE TABLE `chitiethd` (
  `id` int(50) NOT NULL,
  `idHD` int(50) NOT NULL,
  `idsp` int(50) NOT NULL,
  `tensanpham` varchar(200) NOT NULL,
  `soluong` int(50) NOT NULL,
  `giatien` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `chitiethd`
--

INSERT INTO `chitiethd` (`id`, `idHD`, `idsp`, `tensanpham`, `soluong`, `giatien`) VALUES
(1, 1, 1, 'Điện Thoại Oppo A12', 1, 2420000),
(2, 1, 2, 'Điện thoại Vivo Y1S', 1, 1990000),
(3, 8, 18, 'Laptop Dell Inspiron 3493 Core i3-1005G1', 1, 12950000),
(4, 8, 16, 'Laptop HP 245 G8 (345R8PA)', 1, 14190000),
(5, 9, 19, 'Laptop HP ProBook 430 G8 2H0N8PA ', 2, 37838000),
(6, 10, 17, 'Laptop Asus VivoBook M513UA-EJ033T', 3, 53787000),
(7, 10, 13, 'Điện Thoại Nokia 5.4 (4GB/128GB)', 5, 14950000),
(8, 11, 19, 'Laptop HP ProBook 430 G8 2H0N8PA ', 2, 37838000),
(9, 11, 17, 'Laptop Asus VivoBook M513UA-EJ033T', 3, 53787000),
(10, 12, 13, 'Điện Thoại Nokia 5.4 (4GB/128GB)', 5, 14950000),
(11, 12, 12, 'Điện thoại Xiaomi Redmi Note 10', 1, 4690000),
(12, 13, 12, 'Điện thoại Xiaomi Redmi Note 10', 3, 14070000),
(13, 13, 16, 'Laptop HP 245 G8 (345R8PA)', 1, 14190000),
(14, 13, 13, 'Điện Thoại Nokia 5.4 (4GB/128GB)', 1, 2990000),
(15, 14, 2, 'Điện thoại Vivo Y1S', 3, 5970000),
(16, 14, 18, 'Laptop Dell Inspiron 3493 Core i3-1005G1', 2, 25900000),
(17, 15, 2, 'Điện thoại Vivo Y1S', 1, 1990000),
(18, 15, 4, 'Laptop Asus ExpertBook P2451FA-EK1621', 2, 33278000),
(19, 15, 18, 'Laptop Dell Inspiron 3493 Core i3-1005G1', 4, 51800000),
(20, 16, 18, 'Laptop Dell Inspiron 3493 Core i3-1005G1', 2, 25900000),
(21, 16, 2, 'Điện thoại Vivo Y1S', 1, 1990000),
(22, 16, 9, 'Laptop DELL Inspiron 15 7501 X3MRY1', 2, 57800000),
(23, 17, 2, 'Điện thoại Vivo Y1S', 2, 3980000),
(24, 17, 7, 'Laptop HP 14s-dk1055au 171K9PA', 4, 37956000),
(25, 18, 19, 'Laptop HP ProBook 430 G8 2H0N8PA ', 1, 18919000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `id` int(50) NOT NULL,
  `tenkhachhang` varchar(200) NOT NULL,
  `diachi` varchar(300) NOT NULL,
  `sdt` int(50) NOT NULL,
  `thoigian` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`id`, `tenkhachhang`, `diachi`, `sdt`, `thoigian`) VALUES
(1, 'Mai Anh Hòa', '16,Lê Thiện Trị,Hòa Hải,Ngũ Hành Sơn,TP.Đà Nẵng', 494848454, '2021-06-02 18:05:58'),
(2, 'Nguyễn Đức Quang Phú', '46Lê Thiện Trị, Hòa Hải, Ngũ Hành Sơn, Đà Nẵng', 46678488, '2021-06-02 19:06:20'),
(3, 'Nguyễn Văn A', 'Việt Nam', 64957469, '2021-06-03 19:15:35'),
(5, 'Nguyễn Văn A', 'Việt Nam', 64957469, '2021-06-02 19:26:54'),
(6, 'Nguyễn Văn A', 'Việt Nam', 64957469, '2021-06-03 19:37:10'),
(7, 'Lê Thị B', 'Việt Nam', 67878484, '2021-06-02 19:47:32'),
(8, 'AAA', 'Việt Nam', 8454564, '2021-06-03 19:48:57'),
(9, 'A', 'tp.hcm', 6484646, '2021-06-03 20:08:12'),
(10, 'B', 'Hà Nội', 6454669, '2021-06-03 20:18:25'),
(11, 'jxb', 'hf ch', 64545659, '2021-06-03 20:20:35'),
(12, 'hg', 'khgv', 85680, '2021-06-03 20:28:59'),
(13, 'gv', 'vhv', 8520024, '2021-06-03 20:30:18'),
(14, 'hxbb', 'hxvxv', 784543, '2021-06-03 21:09:31'),
(15, 'bdv', 'nxjxb', 87842, '2021-06-03 18:09:47'),
(16, 'hxbxb', 'bxhxj', 494348, '2021-06-03 18:10:56'),
(17, 'hsvsv', 'bxjxb', 84648, '2021-06-03 18:11:26'),
(18, 'hxbxb', 'jajajz', 6434869, '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaisp`
--

CREATE TABLE `loaisp` (
  `id` int(20) NOT NULL,
  `tenloaisp` varchar(100) NOT NULL,
  `hinhloaisp` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `loaisp`
--

INSERT INTO `loaisp` (`id`, `tenloaisp`, `hinhloaisp`) VALUES
(1, 'Điện Thoại', 'http://simpleicon.com/wp-content/uploads/iphone.png'),
(2, 'Laptop', 'https://i.pinimg.com/736x/20/ca/a3/20caa341782a8c576064f4c9ce6fd61a.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nguoidung`
--

CREATE TABLE `nguoidung` (
  `id` int(50) NOT NULL,
  `taikhoan` varchar(50) NOT NULL,
  `matkhau` varchar(255) NOT NULL,
  `quyen` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `nguoidung`
--

INSERT INTO `nguoidung` (`id`, `taikhoan`, `matkhau`, `quyen`) VALUES
(1, 'admin', 'admin', 'admin'),
(2, 'anhhoa', '123456', 'khách hàng'),
(3, 'vanan', '123456', 'khách hàng'),
(4, 'hcm', '123', 'khách hàng'),
(5, 'vn', '123', 'khách hàng'),
(6, 'vietnam', '123', 'khách hàng'),
(7, 'vietn', '123', 'khách hàng'),
(8, 'vzvz', '123', 'khách hàng'),
(9, 'anhh', '123', 'khách hàng'),
(10, 'anhho', '123', 'khách hàng');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `id` int(50) NOT NULL,
  `tensp` varchar(200) NOT NULL,
  `giasp` int(50) NOT NULL,
  `hinhsp` varchar(200) NOT NULL,
  `motasp` varchar(10000) NOT NULL,
  `idloaisp` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`id`, `tensp`, `giasp`, `hinhsp`, `motasp`, `idloaisp`) VALUES
(1, 'Điện Thoại Oppo A12', 2420000, 'https://cdn.nguyenkimmall.com/images/thumbnails/600/336/detailed/705/10047089-dien-thoai-oppo-a12-3gb-32gb-bac-1.jpg', 'Màn hình: IPS LCD, 6.22\", HD+\r\nHệ điều hành: ColorOS 6.1 (Android 9.0)\r\nCamera sau: Chính 13 MP & Phụ 2 MP\r\nCamera trước: 5 MP\r\nCPU: MediaTek Helio P35 8 nhân\r\nRAM: 3 GB\r\nBộ nhớ trong: 32 GB\r\nThẻ nhớ: MicroSD\r\nThẻ SIM:\r\n2 Nano SIM, Hỗ trợ 4G\r\nDung lượng pin: 4230 mAh', 1),
(2, 'Điện thoại Vivo Y1S', 1990000, 'https://cdn.tgdd.vn/Products/Images/42/225851/vivo-y1s-xanh-200x200.jpg', 'Màn hình: IPS LCD, 6.22\", HD+\r\nHệ điều hành: Android 10\r\nCamera sau: 13 MP\r\nCamera trước: 5 MP\r\nCPU: MediaTek Helio P35 8 nhân\r\nRAM: 2 GB\r\nBộ nhớ trong: 32 GB\r\nThẻ nhớ: MicroSD, hỗ trợ tối đa 256 GB\r\nThẻ SIM:\r\n2 Nano SIM, Hỗ trợ 4G\r\nDung lượng pin: 4030 mAh', 1),
(3, 'Apple Macbook Air 2020 M1', 24990000, 'https://salt.tikicdn.com/cache/w444/ts/product/a7/e8/d6/b635dcca294a5a1f6a95fbe8d5d66681.jpg', 'Hiệu năng mạnh mẽ\r\nMacBook Air mới sử dụng chip M1 có CPU 8 lõi, được chia thành 4 lõi hiệu suất cao (High Performance) và 4 lõi hiệu quả (High Efficiency) cùng với Neural Engine 16 lõi.', 2),
(4, 'Laptop Asus ExpertBook P2451FA-EK1621', 16639000, 'https://hanoicomputercdn.com/media/product/57953_p2451__3_.jpg', 'Thiết kế theo kiến trúc tối giản, bền bỉ, thanh lịch\r\nCác nhà thiết kế của Asus đã lấy cảm hứng từ kiến ​​trúc tối giản, mang đến cho chiếc Laptop Asus ExpertBook P2451FA-EK1621 những đường nét mạnh mẽ và táo bạo, các cạnh được bo tròn một cách tinh tế và được khoác lên màu sắc Star Black bóng bẩy để mang đến cho chiếc laptop Asus này vẻ ngoài thanh lịch và chuyên nghiệp.\r\n\r\nAsus ExpertBook P2451FA có kích thước nhỏ gọn với trọng lượng chỉ khoảng 1.55 kg giúp bạn có thể dễ dàng cho thiết bị vào túi xách hoặc ba lô và đem đi mọi nơi. ', 2),
(5, 'Điện Thoại iPhone 12 Pro Max 128GB', 28990000, 'https://salt.tikicdn.com/cache/280x280/ts/product/86/dd/0c/867625c22f9e6ef1467409bcae2ac1a9.jpg', 'Hàng chính hãng VN/A\r\nBộ nhớ trong 128 GB\r\nLoại SIM Dual SIM (nano‑SIM and eSIM)\r\nLoại màn hình Super Retina XDR OLED, HDR10, Dolby Vision, Wide color gamut, True-tone\r\nKích thước màn hình 6.7 inches\r\nĐộ phân giải màn hình 1284 x 2778 pixels\r\nHệ điều hành iOS\r\nPhiên bản hệ điều hành iOS 14', 1),
(6, 'Điện Thoại Vsmart Live 4 (6GB/64GB)', 3495000, 'https://cdn.tgdd.vn/Products/Images/42/227529/vsmart-live-4-trang-200x200.jpg', 'Màn hình: LTPS IPS LCD, 6.5\", Full HD+\r\nHệ điều hành: Android 10\r\nCamera sau: Chính 48 MP & Phụ 8 MP, 5 MP, 2 MP\r\nCamera trước: 13 MP\r\nCPU: Snapdragon 675 8 nhân\r\nRAM: 6GB\r\nBộ nhớ trong: 64GB\r\nThẻ SIM: 2 Nano SIM, Hỗ trợ 4G\r\nDung lượng pin: 5000 mAh, có sạc nhanh', 1),
(7, 'Laptop HP 14s-dk1055au 171K9PA', 9489000, 'https://quangmai.net/wp-content/uploads/2021/03/10046532-hp-14s-dk1055au-amd-r3-3250u-14-inch-171k9pa-1_bv2s-h8.jpg', 'CPU: AMD Ryzen 3 3250U\r\nRAM: 4GB\r\nỔ cứng: 256GB SSD\r\nVGA:\r\nRadeon Vega 3 Graphics\r\nMàn hình: 14 inch HD\r\nHệ điều hành: Win 10\r\nTrước mắt bạn sẽ là chiếc laptop màu bạc hết sức thanh lịch, nhỏ gọn và thời trang. Bên cạnh màu sắc đẹp mắt, điểm nhấn ấn tượng nhất trong thiết kế Laptop HP 14s-dk1055au 171K9PA chính là màn hình viền mỏng ở 2 cạnh bên. Xu hướng thiết kế mới này giúp laptop có thể đặt màn hình 14 inch vào trong một bộ khung 13 inch, nhỏ gọn hơn bao giờ hết. Bạn có thể dễ dàng cho HP 14s vào túi xách, cầm trên tay nhẹ nhàng để di chuyển bất cứ nơi đâu. Laptop có trọng lượng chỉ 1,47kg và độ dày chưa đến 2cm, vô cùng gọn nhẹ.', 2),
(8, 'Microsoft Surface Pro 7 Model QWV-00007', 25799000, 'https://salt.tikicdn.com/ts/product/d1/9e/74/d8b3807a6165e4bf94f9d002b6ca0b31.jpg', 'Surface Pro 7 Core i5 RAM 8GB SSD 256GB - Sự Lựa Chọn Hoàn Hảo Nhất\r\n\r\nSurface Pro 7 Core i5 RAM 8GB SSD 256GB ra mắt và đáp ứng đầy đủ mong muốn của người dùng ở một chiếc laptop 2 in 1 cả về thiết kế lẫn cấu hình hiện đại nhất cùng giá cả hợp lý. Đây cũng là lý do vì sao thiết bị này luôn tạo được sức hút với đông đảo người yêu công nghệ.', 2),
(9, 'Laptop DELL Inspiron 15 7501 X3MRY1', 28900000, 'https://anphat.com.vn/media/product/34007_dell_inspiron_15_7501.jpg', 'Hệ điều hành: Win 10 bản quyền\r\nCPU: Intel Core i7 10750H 2.6GHz, 12MB\r\nRAM: 8GB onboard DDR4/ 2933MHz (1 slot)\r\nỔ đĩa cứng: 512GB SSD PCIe (M.2 2230) – combo M.2 2230/2280\r\nVGA: NVIDIA GEFORCE GTX 1650Ti 4GB GDDR6\r\nMàn hình: 15.6” inch diagonal Full HD (1920 x 1080) @60Hz Wide View Angle (WVA), Anti glare\r\nThiết kế mỏng nhẹ hơn\r\nSang trọng, đẳng cấp với với màu bạc tinh tế, hoàn thiện chắc chắn và vát mỏng đều ở các góc cạnh. Bên cạnh đó Dell đã thiết kế mỏng nhẹ hơn với trọng lượng chỉ 1.8kg dễ dàng mang theo di chuyển đến mọi nơi.\r\n\r\nLaptop DELL Inspiron 15 7501 X3MRY1 còn được thiết kế với quạt kép, ống dẫn nhiệt kép và thiết kế bản lề giúp hệ thống của bạn mát mẻ khi làm việc, trong khi lỗ thông hơi mới phía trên bàn phím và dưới máy tính xách tay cải thiện luồng không khí, giúp giữ cho máy tính của bạn luôn mát mẻ, vận hành êm ái.', 2),
(10, 'Điện Thoại Samsung Galaxy A02s', 2850000, 'https://cdn.tgdd.vn/Products/Images/42/230525/samsung-galaxy-a02s-xanh-600x600-1-200x200.jpg', 'Thiết kế tối giản nhưng không kém phần hút mắt\r\nSamsung Galaxy A02s sở hữu thiết kế trẻ trung bắt mắt, thân máy với các cạnh viền được bo cong mềm mại, mang đến cảm giác vừa vặn, dễ dàng thao tác và tiện lợi khi sử dụng.', 1),
(11, 'Điện Thoại iPhone 12 128GB', 21990000, 'https://cdn.tgdd.vn/Products/Images/42/228736/iphone-12-xanh-duong-200x200.jpg', 'Hàng chính hãng mã VN/A, Mới 100%, Nguyên Seal\r\nBộ nhớ trong: 128 GB\r\nLoại SIM: Dual SIM (nano‑SIM and eSIM)\r\nLoại màn hình: Super Retina XDR OLED, HDR10, Dolby Vision, Wide color gamut, True-tone\r\nKích thước màn hình: 6.1 inches\r\nĐộ phân giải màn hình: 1170 x 2532 pixels\r\nHệ điều hành: iOS14', 1),
(12, 'Điện thoại Xiaomi Redmi Note 10', 4690000, 'https://www.xtmobile.vn/vnt_upload/product/08_2019/thumbs/600_xiaomi-redmi-note-10-5g-xtmobile_1.jpg', 'Đặc điểm nổi bật của Xiaomi Redmi Note 10 (6GB/128GB)\r\nBộ sản phẩm chuẩn: Hộp, Sạc, Sách hướng dẫn, Ốp lưng, Cáp Type C - Type A, Củ sạc nhanh rời đầu Type A\r\n\r\nĐã trình làng chiếc điện thoại mang tên gọi là  với điểm nhấn chính là cụm 4 camera 48 MP, chip rồng Snapdragon 678 mạnh mẽ cùng nhiều nâng cấp như dung lượng pin 5.000 mAh và hỗ trợ sạc nhanh 33 W tiện lợi.\r\nThiết kế đẹp mắt, sang trọng đến từng chi tiết\r\nXiaomi Redmi Note 10 sở hữu khung viền kim loại kết hợp với mặt lưng kính có hiệu ứng màu sắc đem lại một ngoại hình sang trọng và bắt mắt.\r\n\r\nTổng trọng lượng của máy chỉ 178.8 g cùng thiết kế  ấn tượng với độ mỏng 8.29 mm, cho trải nghiệm cầm nắm thao tác thoải mái, mang điện thoại đi khắp nơi thật dễ dàng.\r\n\r\nmột chạm được tích hợp ở cạnh viền giúp việc mở khóa điện thoại nhanh chóng và cho cảm giác cầm tay thoải mái.\r\n\r\nXiaomi Redmi Note 10 đem đến cho người tiêu dùng 3 tùy chọn màu sắc bao gồm: Trắng, Đen và Xanh tự do lựa chọn cho phong cách của bạn.', 1),
(13, 'Điện Thoại Nokia 5.4 (4GB/128GB)', 2990000, 'https://cdn.tgdd.vn/Products/Images/42/231706/nokia-54-xanh-600x600-200x200.jpg', 'Thiết kế nguyên khối bền bỉ chắc chắn\r\nMặc dù là một chiếc smartphone được sản xuất trong phân khúc giá tầm trung nhưng Nokia 5.4 không hề lỗi thời với lối thiết kế nguyên khối vô cùng cứng cáp, mặt lưng làm từ nhựa phủ bóng giả kính vô cùng sang trọng và bắt mắt.\r\n\r\nMáy có kích thước vô cùng nhỏ gọn với phần cạnh viền được làm cong nhẹ êm ái cho người dùng cảm giác cầm nắm dễ dàng khi sử dụng.\r\n\r\nNokia 5.4 sở hữu thiết kế màn hình khoét lỗ bắt kịp xu hướng trong thiết kế smartphone mới, mang lại không gian giải trí rộng lớn mà vẫn nằm gọn trong lòng bàn tay người dùng.\r\n\r\nCụ thể, màn hình trên chiếc Nokia 5.4 có kích thước lớn 6.39 inch cho người dùng không gian xem phim, chơi game vô cùng thoải mái.\r\n\r\nNgoài ra, màn hình sử dụng tấm nền IPS LCD với độ phân giải HD+ (720 x 1560 Pixels), tỷ lệ 18:9 mật đổ điểm ảnh 246 ppi giúp người dùng nâng cao trải nghiệm khi sử dụng cho hình ảnh sắc nét.\r\n\r\nMáy vẫn giữ cảm biến vân tay ở mặt sau thay vì đưa sang phím nguồn hay trong màn hình cho khả năng nhận diện nhanh và vô cùng chính xác.', 1),
(16, 'Laptop HP 245 G8 (345R8PA)', 14190000, 'https://hc.com.vn/i/ecommerce/media/GS.007640_DESKTOP_80424.jpg', 'Laptop HP 245 G8 R5 (345R8PA) là phiên bản nâng cấp nhẹ của series G7 với thiết kế gọn gàng hơn, hiệu năng mạnh mẽ và nhiều tính năng tiện ích hơn, phù hợp cho các bạn sinh viên, dân làm việc văn phòng. \r\nMỏng nhẹ hơn, tiện lợi hơn \r\nLaptop HP mang đến thiết kế nhỏ gọn hơn so với phiên bản G7 tiền nhiệm, với độ dày chỉ 19.9 mm, trọng lượng 1.47 kg, HP G8 tự tin đồng hành cùng bạn mỗi ngày. Tuy được làm từ chất liệu nhựa nhưng chiếc máy có độ hoàn thiện cao, màu xám bạc bắt mắt tạo nên tổng thể máy sang trọng hơn.\r\nChiếc laptop mỏng nhẹ này trang bị cho mình 1 cổng HDMI, 2 cổng SuperSpeed USB A, USB Type-C truyền dữ liệu cực nhanh cùng với chuẩn Wi-Fi 6 - 802.11ax và Bluetooth v5.0 cho các kết nối nhanh chóng, ổn định, phục vụ tối ưu cho công việc hằng ngày của bạn.\r\n\r\nHiệu năng mạnh mẽ trong tầm giá \r\nHP 245 G8 sử dụng bộ vi xử lí AMD Ryzen 5 3500U giúp chạy mượt các ứng dụng văn phòng, doanh nghiệp phổ biến, làm đồ họa, cắt ghép hình ảnh cơ bản như Photoshop, AI,... Con chip có xung nhịp cao nhất đạt 3.7 GHz, được sản xuất trên tiến trình 7 nm giúp tiết kiệm năng lượng, hiệu suất làm việc cao. ', 2),
(17, 'Laptop Asus VivoBook M513UA-EJ033T', 17929000, 'https://cdn.cellphones.com.vn/media/catalog/product/cache/7/thumbnail/9df78eab33525d08d6e5fb8d27136e95/l/a/laptop-asus-vivobook-m513ua-ej033t-1.png', 'Cấu hình mạnh mẽ\r\nLaptop Asus VivoBook M513UA-EJ033T (AMD R7-5700U/ 8GB (4GB Onboard + 4GB) DDR4 3200MHz/ 512GB SSD M.2 PCIE G3X2/ 15.6 FHD/ Win10) - Hàng Chính Hãng được trang bị vi xử lý AMD Ryzen 7-5700U (1.80GHz up to 4.30GHz, 8MB) cùng với bộ nhớ trong 8 GB RAM cung cấp khả năng hỗ trợ tốt mọi ứng dụng về văn phòng như Word, Excel, PowerPoint. Bên cạnh đó máy có thể xử lí Photoshop với nhu cầu cắt ghép đơn giản, không chuyên.\r\n\r\nKhông gian lưu trữ lớn\r\nKho lưu trữ dữ liệu vô cùng lớn gồm 512GB SSD, giúp người dùng tận hưởng không gian số vô cùng rộng rãi thỏa mái lưu trữ dữ liệu mà không hề lo lắng.\r\n\r\nKết nối toàn diện\r\nTrang bị đầy đủ các cổng kết nối gồm cổng 2 USB 2.0; 1 USB 3.0; 1 USB Type-C; HDMI người dùng kết nối mọi thứ vô cùng dễ dàng và nhanh chóng.', 2),
(18, 'Laptop Dell Inspiron 3493 Core i3-1005G1', 12950000, 'https://www.sieuthimaychu.vn/datafiles/setone/15897692904093.jpg', 'LAPTOP DELL BRAND NEW NHẬP KHẨU MỸ\r\n\r\n \r\n\r\nCPU:  Intel Core i5-1035G1 Quad Core Processor\r\nRAM: 8GB  2666MHz DDR4 RAM\r\nỔ cứng: 512GB NVMe M.2 Solid State Drive\r\nMàn hình: 14.0″ FHD LED Backlit Anti-Glare Display\r\nĐồ họa: Integrated Intel UHD Graphics\r\nKết nối:  1x power connector\r\n1x card reader\r\n1x HDMI 1.4b\r\n1x headphone / microphone combo jack (3.5mm)\r\n1x USB 2.0\r\n2x USB 3.2 Gen 1\r\nMàu sắc: Platinum – Grey\r\nTrọng lượng:   1.6 Kg\r\nHệ điều hành:  Windows 10 Home 64\r\nBảo hành : 12 tháng', 2),
(19, 'Laptop HP ProBook 430 G8 2H0N8PA ', 18919000, 'https://cellphones.com.vn/media/catalog/product/l/a/laptop-hp-probook-430-g8-2h0n8pa-1.jpg', 'Thiết kế hiện đại cho phong cách làm việc hiện đại\r\nLaptop HP ProBook 430 G8 2H0N8PA (Core i5-1135G7/ 8GB DDR4 3200MHz/ 256GB SSD PCIe NVMe/ 13.3 FHD IPS/ Win10) - Hàng Chính Hãng với thiết kế mới mẻ, mỏng nhẹ, Laptop HP ProBook 430 G8 2H0N8PA mang lại hiệu suất vượt trội, khả năng bảo mật và độ bền phù hợp cho từng nhu cầu sử dụng. Từ học tập, làm việc hay sử dụng trong công ty, tổ chức và cả những công việc cần mang laptop theo bên mình.\r\n\r\nKiểu dáng mới mẻ\r\nKhung máy nhỏ gọn, mỏng nhẹ, 15.9mm với các thành phần bằng nhôm, dễ dàng mang theo từ nơi này đến nơi khác. Tận hưởng tỷ lệ màn hình trên thân máy hơn 84%, kích thước đường chéo 13.3-Inch cùng độ phân giải FHD (1920 x 1080), bàn phím nhạy và yên tĩnh.\r\n\r\nBảo vệ nhiều lớp\r\nDoanh nghiệp luôn đỏi hỏi sự bảo vệ, bảo mật trên một chiếc laptop với các tính năng bảo mật cấp thương mại. Laptop HP ProBook 430 G8 được tăng cường các tính năng bảo mật và riêng tư từ BIOS trở lên.', 2);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `binhluan`
--
ALTER TABLE `binhluan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idsp` (`idsp`),
  ADD KEY `iduser` (`iduser`);

--
-- Chỉ mục cho bảng `chitiethd`
--
ALTER TABLE `chitiethd`
  ADD PRIMARY KEY (`id`),
  ADD KEY `hoadon` (`idHD`),
  ADD KEY `sanpham` (`idsp`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `loaisp`
--
ALTER TABLE `loaisp`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `nguoidung`
--
ALTER TABLE `nguoidung`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`id`),
  ADD KEY `loai sp` (`idloaisp`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `binhluan`
--
ALTER TABLE `binhluan`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `chitiethd`
--
ALTER TABLE `chitiethd`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT cho bảng `loaisp`
--
ALTER TABLE `loaisp`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `nguoidung`
--
ALTER TABLE `nguoidung`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `binhluan`
--
ALTER TABLE `binhluan`
  ADD CONSTRAINT `binhluan_ibfk_1` FOREIGN KEY (`idsp`) REFERENCES `sanpham` (`id`),
  ADD CONSTRAINT `binhluan_ibfk_2` FOREIGN KEY (`iduser`) REFERENCES `nguoidung` (`id`);

--
-- Các ràng buộc cho bảng `chitiethd`
--
ALTER TABLE `chitiethd`
  ADD CONSTRAINT `hoadon` FOREIGN KEY (`idHD`) REFERENCES `hoadon` (`id`),
  ADD CONSTRAINT `sanpham` FOREIGN KEY (`idsp`) REFERENCES `sanpham` (`id`);

--
-- Các ràng buộc cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `loai sp` FOREIGN KEY (`idloaisp`) REFERENCES `loaisp` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

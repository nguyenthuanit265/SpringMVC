USE QUANLYBANHANG;
SELECT *FROM KHACHHANG;
SELECT *FROM NHANVIEN;
SELECT *FROM HOADON;
SELECT *FROM SANPHAM;
SELECT *FROM CTHD;

-- 1. In ra danh sách các sản phẩm (MASP,TENSP) do “Trung Quoc” sản xuất.
SELECT *FROM SANPHAM SP WHERE SP.NUOCSX= "Trung Quoc";

-- 2. In ra danh sách các sản phẩm (MASP, TENSP) có đơn vị tính là “cay”, ”quyen”.
SELECT SP.MASP, SP.TENSP
FROM SANPHAM SP
WHERE SP.DVT = 'cay' or SP.DVT = 'quyen';

-- 3. In ra danh sách các sản phẩm (MASP,TENSP) có mã sản phẩm bắt đầu là “B” và kết thúc là “01”.
SELECT SP.MASP, SP.TENSP
FROM SANPHAM SP
WHERE SP.MASP LIKE 'B%' AND SP.MASP LIKE '%01';

-- 4. In ra danh sách các sản phẩm (MASP,TENSP) do “Trung Quốc” sản xuất có giá từ 30.000 đến 40.000.
SELECT *FROM SANPHAM SP WHERE SP.NUOCSX= "Trung Quoc" AND SP.GIA BETWEEN 30000 AND 40000 ;

-- 5. In ra danh sách các sản phẩm (MASP,TENSP) do “Trung Quoc” hoặc “Thai Lan” sản xuất có giá từ 30.000 đến 40.000.
SELECT SP.MASP, SP.TENSP 
FROM SANPHAM SP 
WHERE SP.GIA BETWEEN 30000 AND 40000 
AND SP.MASP IN (SELECT SP2.MASP
				FROM SANPHAM SP2 
				WHERE SP2.NUOCSX = 'Thai Lan' OR SP2.NUOCSX= 'Trung Quoc')
;


-- 6. In ra các số hóa đơn, trị giá hóa đơn bán ra trong ngày 1/1/2007 và ngày 2/1/2007.
SELECT HD.SOHD,HD.TRIGIA
FROM HOADON HD
WHERE HD.NGHD = '2007-1-1' OR HD.NGHD = '2007-1-2';

-- 7. In ra các số hóa đơn, trị giá hóa đơn trong tháng 1/2007, sắp xếp theo ngày (tăng dần) và trị giá của hóa đơn (giảm dần).
SELECT HD.SOHD,HD.TRIGIA
FROM HOADON HD
WHERE MONTH(HD.NGHD) = 1 AND YEAR (HD.NGHD) = 2007 
order by DAY (HD.NGHD) ASC , HD.TRIGIA DESC;

-- Bài tập
-- 1. In ra danh sách các khách hàng (MAKH, HOTEN) đã mua hàng trong ngày 1/1/2007.
SELECT KH.MAKH,KH.HOTEN
FROM KHACHHANG KH join HOADON HD ON (KH.MAKH=HD.MAKH)
WHERE HD.NGHD = '2007-1-1';

-- 2. In ra số hóa đơn, trị giá các hóa đơn do nhân viên có tên “Nguyen Van B” lập trong ngày 28/10/2006.
SELECT HD.SOHD,HD.TRIGIA
FROM HOADON HD, NHANVIEN NV
WHERE HD.MANV = NV.MANV AND NV.HOTEN = 'Nguyen Van B' AND HD.NGHD = '2006-10-28';

-- 3. Tìm các số hóa đơn đã mua sản phẩm có mã số “BB01” hoặc “BB02”.
SELECT DISTINCT HD.SOHD
FROM HOADON HD JOIN CTHD CT ON (HD.SOHD = CT.SOHD)
WHERE CT.MASP= 'BB01' OR CT.MASP = 'BB02';

-- 4. Tìm các số hóa đơn đã mua sản phẩm có mã số “BB01” hoặc “BB02”, mỗi sản phẩm mua với số lượng từ 10 đến 20.
SELECT DISTINCT HD.SOHD
FROM HOADON HD JOIN CTHD CT ON (HD.SOHD = CT.SOHD)
WHERE CT.SL BETWEEN 10 AND 20 AND CT.MASP= 'BB01' OR CT.SL BETWEEN 10 AND 20 AND CT.MASP = 'BB02';

-- 5. Cho biết trị giá hóa đơn cao nhất, thấp nhất là bao nhiêu ?
SELECT MAX(HD.TRIGIA) AS TriGiaCaoNhat , MIN(HD.TRIGIA) AS TriGiaThapNhat
FROM HOADON HD ;

-- 6. Trị giá trung bình của tất cả các hóa đơn được bán ra trong năm 2006 là bao nhiêu?
SELECT AVG(HD.TRIGIA) AS TRUNGBINH
FROM HOADON HD 
WHERE YEAR (HD.NGHD) = '2006';

-- 7. Tính doanh thu bán hàng trong năm 2006.
SELECT SUM(HD.TRIGIA*CT.SL) AS DOANHTHU
FROM HOADON HD JOIN CTHD CT ON (HD.SOHD=CT.SOHD)
WHERE YEAR (HD.NGHD) = '2006';

-- 8. In ra danh sách 3 khách hàng (MAKH, HOTEN) có doanh số cao nhất.
SELECT *
FROM KHACHHANG KH
ORDER BY KH.DOANHSO DESC
LIMIT 0,3;

-- Bài tập
-- 1. Tính tổng số sản phẩm do “Trung Quoc” sản xuất.
SELECT COUNT(SP.MASP) AS SOSP
FROM SANPHAM SP
WHERE SP.NUOCSX='Trung Quoc';

-- 2. Tính tổng số sản phẩm của từng nước sản xuất.
SELECT SP.NUOCSX, COUNT(SP.MASP) AS SOSP
FROM SANPHAM SP
group by SP.NUOCSX;

-- 3. Với từng nước sản xuất, tìm giá bán cao nhất, thấp nhất, trung bình của các sản phẩm.
SELECT SP.NUOCSX, MAX(SP.GIA) AS CAONHAT, MIN(SP.GIA) AS THAPNHAT, AVG(SP.GIA) AS TRUNGBINH
FROM SANPHAM SP
group by SP.NUOCSX;

-- 4. Tính doanh thu bán hàng mỗi ngày.
SELECT HD.NGHD, SUM(HD.TRIGIA*CT.SL) AS DOANHTHU
FROM HOADON HD JOIN CTHD CT ON (HD.SOHD=CT.SOHD)
GROUP BY HD.NGHD;

-- Bài tập Join - SubQuery
-- 1. Lấy ra số họ tên, số điện thoại, địa chỉ, trị giá của những khách hàng có hóa đơn thanh toán nhỏ hơn 300.000 đ.
SELECT KH.HOTEN,KH.SODT,KH.DCHI,HD.TRIGIA
FROM KHACHHANG KH JOIN HOADON HD ON (KH.MAKH=HD.MAKH)
WHERE HD.TRIGIA < 300000;

-- 2. Lấy ra tên sản phẩm, nước sản xuất, số lượng, giá bán của những sản phẩm có số lượng bán ra trên 50 sản phẩm trên mỗi hóa đơn.
SELECT SP.MASP,SP.TENSP,SP.NUOCSX,CT.SL,SP.GIA, SUM(CT.SL) AS TONGSL
FROM SANPHAM SP LEFT JOIN CTHD CT ON (SP.MASP=CT.MASP)
GROUP BY SP.MASP
HAVING SUM(CT.SL) > 50;

-- 3. In ra danh sách các khách hàng (MAKH, HOTEN) đã mua hàng trong ngày 1/1/2007.
SELECT KH.MAKH, KH.HOTEN
FROM KHACHHANG KH JOIN HOADON HD ON (KH.MAKH=HD.MAKH)
WHERE HD.NGHD='2007-1-1';

-- 4. In ra số hóa đơn, trị giá các hóa đơn do nhân viên có tên “Nguyen Van B” lập trong ngày 28/10/2006.
SELECT HD.SOHD, HD.TRIGIA
FROM HOADON HD JOIN NHANVIEN NV ON (HD.MANV=NV.MANV)
WHERE NV.HOTEN = 'Nguyen Van B' AND HD.NGHD = '2006-10-28';

-- 5. Sử dụng subquery lấy ra tên sản phẩm, nước sản xuất, giá bán của những sản phẩm có số lượng bán ra trên 50 sản phẩm trên mỗi hóa đơn.
SELECT SP.MASP,SP.TENSP
FROM SANPHAM SP
WHERE SP.MASP IN (
				SELECT CT.MASP
                FROM CTHD CT
                GROUP BY CT.MASP
                HAVING SUM(CT.SL) > 50
);

SELECT SP.MASP,SP.TENSP
FROM SANPHAM SP JOIN CTHD CT ON (SP.MASP=CT.MASP)
GROUP BY CT.MASP
HAVING SUM(CT.SL) > 50;

-- 6. Tìm những hóa đơn có mua ít nhất 5 sản phẩm khác nhau.
SELECT HD.SOHD
FROM HOADON HD LEFT JOIN CTHD CT ON (HD.SOHD=CT.SOHD)
GROUP BY CT.SOHD
HAVING COUNT(DISTINCT CT.MASP) >=5; 

SELECT HD.SOHD
FROM HOADON HD
WHERE HD.SOHD IN (
				SELECT CT.SOHD
                FROM CTHD CT
                GROUP BY CT.SOHD
                HAVING COUNT(CT.MASP) >=5
);




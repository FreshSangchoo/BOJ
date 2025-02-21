-- 코드를 입력하세요
SELECT b.BOOK_ID, a.AUTHOR_NAME, DATE_FORMAT(b.PUBLISHED_DATE, '%Y-%m-%d') published_date
FROM BOOK b
left join author a on b.author_id = a.author_id
WHERE b.CATEGORY = '경제'
ORDER BY b.PUBLISHED_DATE
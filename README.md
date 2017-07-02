
There is a Table 'A' containing 2-fields: (WORD, ID) and table 'B' containing: (WORD, ID2). IDs are random and does not match.
Can you please create and fill table 'C' containing: (ID).
Please fill only IDs from records that present in table 'A' but not in 'B', and records that present in table 'B' and not in 'A'.
Match by 'WORD'.
Please solve it in Java without using SQL to calculate result.


---

Используемые технологии: Java-8, Spring, JUnit, HSQL-DB

В качестве тествой базы данных выбрал HSQL-DB.
Для загрузчика данных из базы использовал JdbcTemplate из Spring-а.
(Чтобы наполнить базу данными, написал аля-генератор 'DbGeneratorUtil' - который из файла-имен размножает записи и ложит в базу)
(Нагрузочные тесты проводил чуть меьше на ~1.5-тыс. объектов, в связи с моими мощностями)

После того как выгружаем объекты из базы, получаем коллекцию типа ArrayList.
Встроенных методов этой коллекции достаточно для выполнения условий задачи. Поэтому использовать HashMap небыло необходимости.

Я попытался реализовать 4-способа алгоритма который моделирует поведений SQL-выборки данных из базы:
1. SqlAlgorithmJ7.leftJoinCustom | SqlAlgorithmJ7.rightJoinCustom
2. SqlAlgorithmJ7.leftJoin | SqlAlgorithmJ7.rightJoin
3. SqlAlgorithmJ8.leftJoin | SqlAlgorithmJ8.rightJoin  (SqlAlgorithmJ8.leftJoinToIds | SqlAlgorithmJ8.rightJoinToIds)
4. SqlAlgorithmJ8.leftJoinAlternative | SqlAlgorithmJ8.rightJoinAlternative

---

По результатам тестирования:
- найболее производительным показали stream-методы из Java-8
- найменее производительным показали класические методы (со вложенными циклами)

/* Список фильмов, для каждого — с указанием общего числа посетителей за все время, среднего числа зрителей
за сеанс и общей суммы сборов по каждому фильму (отсортировать по убыванию прибыли).
Внизу таблицы должна быть строчка «итого», содержащая данные по всем фильмам сразу; */

select *
from (select table1.movie,
             sum(table1.sess_qua_sum) as movie_qua_sum,
             avg(table1.sess_qua_sum) as movie_sess_qua_avg,
             sum(table1.ses_cost)     as movie_cost_sum
      from (select s.id                            as session_id,
                   m.name                          as movie,
                   sum(t.quantity)                 as sess_qua_sum,
                   sum(t.quantity * s.cost) as ses_cost
            from session as s
                     join movie as m on s.movie_id = m.id
                     join ticket as t on t.session_id = s.id
            group by s.id) as table1
      group by movie
      order by movie_cost_sum desc) as table2
union all
select 'Total'             as movie,
       sum(movie_qua_sum)  as total_movie_qua,
       ''                  as movie_sess_qua_avg,
       sum(movie_cost_sum) as total_movie_cost
from (select table1.movie,
             sum(table1.sess_qua_sum) as movie_qua_sum,
             avg(table1.sess_qua_sum) as movie_sess_qua_avg,
             sum(table1.ses_cost)     as movie_cost_sum
      from (select s.id                            as session_id,
                   m.name                          as movie,
                   sum(t.quantity)                 as sess_qua_sum,
                   sum(t.quantity * s.cost) as ses_cost
            from session as s
                     join movie as m on s.movie_id = m.id
                     join ticket as t on t.session_id = s.id
            group by s.id) as table1
      group by movie
      order by movie_cost_sum desc) as table3;
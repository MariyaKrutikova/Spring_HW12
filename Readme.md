1) На базе первого примера разобранного на семинаре, добавить в один из проектов разработанных ранее spring Integration. Сохранять запросы от пользователя в файл.
2) Добавить в проект один из паттернов разобранных на лекции.

  ## Пояснения по выполеннию

Задание выполнялось для проекта из ДЗ № 5. В классе TaskController spring Integration использовалось для методов addTask, findTaskByStatus, updateTaskStatus

Для проверки первого задания в классе TaskController нужно раскомментировать стороки 38, 52, 65
и закомментировать - 18, 19, 37, 51, 64. 
 


Для проверки второго задания раскомментировать стороки 18, 19, 37, 51, 64
и закомментировать - 38, 52, 65.
Для выполнения второго задания был реализован паттерн Bridge. 
За основу был взят пример из лекции. Был создан интерфейс MyLog, 
содержащий всего один метод writeLog(). Были созданы два класса FileLog и ConsoleLog, 
имплементирующие интерфейс MyLog, обеспечивающие запись действий в файл или вывод в консоль соответственно.
При записи действия в файл (использовании FilLog) был задействован spring Integration. 
В классе TaskController можно менять только тип логирования - раскомментировать стороку 18 или 19.


# PriorityQueue
implement a min-heap, use the heap to implement a priority queue, and finally use the priority queue to schedule real-time processes

The priority queue uses the heap to provide following functions of the priority queue:

--> insert_with_priority: add an element to the queue with an associated priority.

--> pull_highest_priority_element: remove the element from the queue that has the highest priority,
and return it.

Finally, a driver program which reads a file and adds or removes things from the priority
queue, as well as a class of scheduled processes. The file has lines that have one of two forms:
1. schedule process deadline duration, or
2. run time

<_------------------------------------------------------------------------------_>

Example
 
        INPUT
        
       schedule lunch 1300 30
       schedule work 7200 2300
       schedule homework 2359 300
       run 2400


        OUTPUT
        
       0: adding lunch with deadline 1300 and duration 30
       0: adding work with deadline 7200 and duration 2300
       0: adding homework with deadline 2359 and duration 300
       0: busy with lunch with deadline 1300 and duration 30
       30: done with lunch
       30: busy with homework with deadline 2359 and duration 300
       330: done with homework
       330: busy with work with deadline 7200 and duration 2300
       2400: adding work with deadline 7200 and duration 230



Each line beginning with run time tells your program to advance your internal time variable until it
reaches time. You do this by repeatedly removing the first item from the priority queue, and advancing
the internal time variable by the duration of the process, until the time is reached. If the process
completes before the time is reached, a new process is taken from the priority queue. If there are no
processes left in the priority queue, the internal time is simply set to time. If, on the other hand, the
current process would run past time, it is re-inserted in the priority queue with a duration equal to the
remaining time.

So in the example above, time starts at zero, and when your program reads the line that says

run 2400

it starts to run the first process in the queue, which will be "lunch". Lunch takes 30 minutes, so your
program will remove "lunch" from the queue and set its time variable to 30. The next item removed from
the queue will be "homework" (with an earlier deadline than "work"), which takes time 300. So, the time
variable is set to 330.

Finally, "work" is removed from the queue. The time is now 330, and work is scheduled to take 2300 time
units. But, this run ends at time 2400, whereas if all the work was done now, the run would end at time
2630. So, the time variable is set to 2400, and your program must re-insert "work" into the priority queue
with a deadline of 7200 (the deadline hasn't changed) and a duration of 230 (which is 2300 - (2400 - 330),
the duration minus the difference between the end time and the start time).

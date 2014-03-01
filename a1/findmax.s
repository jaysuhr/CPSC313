
# %eax - temporary/immediate values
# %ecx - max
# %edx - x
# %ebx - x - max
# %esp - stack pointer
# %ebp - pos (index of the most maximum value found so far)
# %esi - n (current index)
# %edi - address of current element in the array


.pos 0x100

main:
    irmovl bottom,  %esp     # initialize stack
    irmovl a,       %edi     # address of the first element of a
    irmovl alen,    %esi
    mrmovl (%esi),  %esi     # number of elements of a


# ready to call findmax: a --> edi, last --> esi

    call findmax
    halt

.pos 0x200
#
# Find position of the maximum element in an array.
#
findmax:
    pushl   %ebx                # save %ebx %ebp %edi %esi
    pushl   %ebp                # ""
    pushl   %edi                # ""
    pushl   %esi                # ""

    rrmovl  %esi,   %ebp        # current pos = n

    irmovl  $0x4,   %eax        # %eax = 4
    mull    %esi,   %eax        # %eax = 4*n
    addl    %eax,   %edi        # %edi = (addr of a) + 4*n = addr of a[n]

    irmovl  $0x1,   %eax
    subl    %eax,   %esi        # n--

    irmovl  $0x4,   %eax
    subl    %eax,   %edi        # %edi = addr of a[n-1] (instead of a[n])
    mrmovl  (%edi), %edx        # x = a[n-1]
    rrmovl  %esi,   %ebp        # pos = n
    rrmovl  %edx,   %ecx        # max = x

    irmovl  $0x0,   %eax
    subl    %eax,   %esi        # begin while loop, if %esi <= 0 exit
    jle     exit

loop:
    irmovl  $0x1,   %eax
    subl    %eax,   %esi        # n--

    irmovl  $0x4,   %eax
    subl    %eax,   %edi        # %edi = a[n-1] (instead of a[n])
    mrmovl  (%edi), %edx        # x = a[n-1]

    rrmovl  %edx,   %ebx        # %ebx = x
    subl    %ecx,   %ebx        # %ebx = x - max
    jle     continue            # if (x - max) <= 0 then max is bigger or equal than x so goto continue

    rrmovl  %esi,   %ebp        # pos = n
    rrmovl  %edx,   %ecx        # max = x

continue:
    irmovl  $0x0,   %eax
    subl    %eax,   %esi
    jne     loop                # goto loop to loop if n-- > 0

exit:
    rrmovl  %ebp,   %eax        # return value of pos stored in %eax
    popl    %esi                # restore %ebx %ebp %edi %esi
    popl    %edi                # ""
    popl    %ebp                # ""
    popl    %ebx                # ""
    ret                         # return pos



#
# Array to sort
#
.pos 0x1000
a:
    .long 99
    .long 9
    .long 21
    .long 13
    .long 6
    .long 26
    .long 35
    .long 32
    .long 15
    .long 17
    .long 101
alen:
    .long 11


#
# Stack (256 thirty-two bit words is more than enough here).
#
.pos 0x3000
top:
    .long 0x00000000, 0x100    # top of stack.
bottom:
    .long 0x00000000          # bottom of stack.


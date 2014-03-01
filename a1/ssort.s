.pos 0x100

main:	irmovl bottom,  %esp     # initialize stack
	irmovl a,       %edi     # address of the first element of a
	irmovl alen,    %esi	  
	mrmovl (%esi),  %esi     # number of elements of a
	irmovl $0x1,    %eax
	subl   %eax,    %esi     # last index in a
					 # ready to call ssort : a --> edi, last --> esi
	call ssort
	halt

.pos 0x200
#
# Selection sort.
#

ssort:
    # %edi - a
    # %esi - last
    
    pushl   %esi            # save %esi
    pushl   %ebx            # save %ebx
    andl    %esi,   %esi    # Set condition codes
    jle     Endloop         # if (last <= 0) skip the loop

Whileloop:
                            # %edi and %esi already have correct values from ssort's caller
                            # assume value of %edi and %esi are NOT changed by findmax
    call    findmax         # pos = findmax(a, last)
                            # after call returns pos is in %eax

    # get addr(to be stored in %ebx) and val(to be stored in %eax) of a[pos]
    rrmovl  %eax,   %ebx    # ebx = pos
    irmovl  $0x4,   %ecx    # ecx = 4
    mull    %ecx,   %ebx    # ebx = 4*pos
    addl    %edi,   %ebx    # ebx = address of a + 4*pos (so address of a[pos])
    mrmovl  (%ebx), %eax    # eax = a[pos]

    # get addr(to be stored in %edx) and val(to be stored in %ecx) of a[last]
    rrmovl  %esi,   %edx    # edx = last
    irmovl  $0x4,   %ecx    # ecx = 4
    mull    %ecx,   %edx    # edx = 4*last
    addl    %edi,   %edx    # edx = address of a + 4*last (so address of a[last])
    mrmovl  (%edx), %ecx    # ecx = a[last]

    # switch a[pos] and a[last]
    rmmovl  %ecx,   (%ebx)  # switch a[last] and a[pos]
    rmmovl  %eax,   (%edx)  # switch a[last] and a[pos]

    # decrement last
    irmovl  $0x1,   %eax
    subl    %eax,   %esi    # last--
    andl    %esi,   %esi    # Set condition codes
    jg      Whileloop       # if (last > 0) loop

Endloop:
    popl   %ebx             # restore %ebx
    popl   %esi             # restore %esi
    ret                     # return to caller



#---------------------------------------------------------

.pos 0x500

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

    mrmovl  (%edi), %edx        # x = a[n]
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


#-----------------------------------------------------------     
	
#
# Array to sort
#
.pos 0x1000
a:	.long 30
      .long 9
      .long 21
      .long 13
.long 12
.long 39
.long 392
.long 35
.long 3
.long 9
.long 90
.long 123
.long 23
.long 38


alen:	.long 14

	#
# Stack (256 thirty-two bit words is more than enough here).
#
.pos 0x3000
top:	            .long 0x00000000, 0x100    # top of stack.
bottom:           .long 0x00000000          # bottom of stack.



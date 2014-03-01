.pos 0x100

main:	irmovl bottom,  %esp     # initialize stack
	irmovl aftera,  %edi     # address of the first element after a
	irmovl a,       %esi     # address of the first element of a.
	subl   %esi,    %edi     # size of the array a in bytes
	irmovl $0x4,    %eax
	divl   %eax,    %edi     # number of elements of a
	call ssort
	halt

#
# Selection sort.
#
ssort:  pushl  %edi              # callee-saved

sloop:	rrmovl %edi,    %eax     # need a spare copy of array size.
	irmovl $0x1,    %ebx     # we want to compute size - 1
        subl   %ebx,    %eax     # now we have it.
	jle    send              # if size < 2, we are done.

        call   findmax           # get position of largest element in %eax
	irmovl $0x1,    %ebx     # we want to compute size - 1
	subl   %ebx,    %edi     # now we have it in words.
	rrmovl %edi,    %edx     # make another copy to keep %edi as is.
	addl   %edx,    %edx     # this is the position in half-words.
	addl   %edx,    %edx     # this is the position in bytes.
	rrmovl %eax,    %ecx     # now the same for position of largest element
        addl   %ecx,    %ecx     # this is the position in half-words.
	addl   %ecx,    %ecx     # this is the position in bytes.
	mrmovl a(%ecx), %eax     # swap a[%ecx] and a[%edx]
	mrmovl a(%edx), %ebx
	rmmovl %eax,    a(%edx)
        rmmovl %ebx,    a(%ecx)
	jmp    sloop

send:	popl   %edi              # restore the saved value of %edi
	ret

#
# Find position of the maximum element in an array.
#
findmax:
	pushl  %edi
	pushl  %esi
	
        irmovl $0x0,    %eax     # initial pos is 0.
	mrmovl a(%eax), %esi     # initial value is a[0]
	
floop:	irmovl $0x1,    %ebx     # we want to compute n - 1
        subl   %ebx,    %edi     # now we have it.
	jle    fmend             # if size < 2, we are done.

	rrmovl %edi,    %edx     # make another copy to keep %edi as is.
	addl   %edx,    %edx     # this is the position in half-words.
	addl   %edx,    %edx     # this is the position in bytes.
        mrmovl a(%edx), %ebx     # this is the array element to check for (x)

	rrmovl %ebx,    %ecx     # make a copy of it.
	subl   %esi,    %ecx     # compare it to current maximum
	jle    floop             # if 0, do nothing.

	rrmovl %ebx,    %esi     # new maximum
	rrmovl %edi,    %eax     # new position for that maximum.
	jmp   floop
	
fmend:  popl   %esi
	popl   %edi
	ret

	
#
# Array to sort
#
.pos 0x1000
a:	.long 35
      .long 9
      .long 21
      .long 13
      .long 6
	.long 26
	.long 30
	.long 32
	.long 15
	.long 17
aftera: .long 0

	#
# Stack (256 thirty-two bit words is more than enough here).
#
.pos 0x3000
top:	            .long 0x00000000,0x100    # top of stack.
bottom:           .long 0x00000000          # bottom of stack.


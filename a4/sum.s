.pos 0x100
sum_function:
	irmovl $a, %edx
	xorl   %eax, %eax
L2:
	mrmovl (%edx), %ebx
	addl   %ebx, %eax
	irmovl $0x4, %ebx
	addl   %ebx, %edx
	irmovl $aend, %ebx
	subl   %edx, %ebx
	jne   L2
	halt

.align 0x4
.pos 0x1000
a:	.long	0x4
	.long	0x7
	.long	0x8
	.long	0x9
	.long	0x12
	.long	0x11
aend: .long 0x0
	
#
# An example showing how to reserve space for a stack (this one
# can hold up to 16 (0x10) 32-bit addresses.
#
.pos 0x3000
top:	            .long 0x00000000,0x10     # top of stack.
bottom:           .long 0x00000000          # bottom of stack.

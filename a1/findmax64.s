	.file	"findmax.c"
	.text
	.p2align 4,,15
	.globl	findmax
	.type	findmax, @function
findmax:
.LFB0:                                  # initializer
	.cfi_startproc
	movslq	%esi, %rax              # %rax = n (sign extend move n into %rax)
	testl	%esi, %esi              # check value of %esi = n
	leaq	0(,%rax,4), %rdx        # %rdx = 4*n
	movl	(%rdi,%rax,4), %r8d     # max = a[n] (%rdi contains addr of a, %rax is n)
	movl	%esi, %eax              # pos = n
	jle	.L2                     # if (n <= 0) goto L2 (return without entering loop) (flag was set on testl line)
	leaq	-4(%rdi,%rdx), %rdx     # %rdx = a[n-1]
	.p2align 4,,10
	.p2align 3
.L4:                            # while loop
	movl	(%rdx), %ecx    # x = a[n-1] (corresponds to x = a[n] line in C code)
	subl	$1, %esi        # n--
	cmpl	%r8d, %ecx      # compare values of max and x
	jle	.L3             # if (x > max) continue, otherwise skip to L3
	movl	%esi, %eax      # pos = n
	movl	%ecx, %r8d      # max = x = a[n]

.L3:                            # still part of while loop
	subq	$4, %rdx        # analogous to n--; %rdx = memory addr of next (technically previous) element in the array
	testl	%esi, %esi      # check value of %esi = n
	jne	.L4             # if (n != 0) goto L4 and loop again
.L2:                            # when while loop ends
	rep                     # help AMD
	ret                     # return to caller (value of pos is in %eax) (return pos;)
	.cfi_endproc
.LFE0:
	.size	findmax, .-findmax
	.ident	"GCC: (Ubuntu/Linaro 4.6.3-1ubuntu5) 4.6.3"
	.section	.note.GNU-stack,"",@progbits

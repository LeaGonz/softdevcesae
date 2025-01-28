<?php $__env->startSection('content'); ?>
<h5>Olá estou em casa.</h5>
<h6><?php echo e($myVar); ?></h6>
<h6><?php echo e($contactInfo['nome']); ?></h6>

<img src="<?php echo e(asset('img/carrossel-3.jpg')); ?>" alt="">
<ul>
    <li><a href="<?php echo e(route('users.show')); ?>">Todos os users</a></li>
    <li><a href="<?php echo e(route('users.add')); ?>">Adicionar Utilizador</a></li>
    <li><a href="<?php echo e(route('tarefas.allTarefas')); ?>">Tarefas 21/01/2025</a></li>
</ul>
<?php $__env->stopSection(); ?>
<?php $__env->startSection('content2'); ?>
<h3>Content 2</h3>
<?php $__env->stopSection(); ?>

<?php echo $__env->make('layouts.fo_layout', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\Users\sw2024\Desktop\softdevcesae\PHP (Laravel)\WebServerSide\resources\views/home.blade.php ENDPATH**/ ?>
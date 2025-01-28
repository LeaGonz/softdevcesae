<?php $__env->startSection('content'); ?>
    <h1>TAREFAS</h1>
    <ul>
        <?php $__currentLoopData = $tarefas; $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $tarefa): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
        <li><?php echo e($tarefa['name']); ?> | <?php echo e($tarefa['task']); ?></li>
        <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
    </ul>
    <h1>AVAILABLE TASKS</h1>
    <ul>
        <?php $__currentLoopData = $availableTasks; $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $availableTask): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
        <li><?php echo e($availableTask); ?></li>
        <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
    </ul>
<?php $__env->stopSection(); ?>

<?php echo $__env->make('layouts.fo_layout', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\Users\sw2024\Desktop\softdevcesae\PHP (Laravel)\WebServerSide\resources\views/tarefas/allTarefas.blade.php ENDPATH**/ ?>